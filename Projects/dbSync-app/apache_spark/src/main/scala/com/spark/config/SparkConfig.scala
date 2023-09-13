package com.spark.config

import com.spark.models.bands.Bands
import org.apache.spark.sql.functions.{col, from_json}
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{Dataset, Encoders, SaveMode, SparkSession}
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

trait SparkConfig {

  //Method to read from kafka as a dataset with kafka configurations
  def readFromKafka(spark: SparkSession): Dataset[Bands] = {
    import spark.implicits._
    spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "localhost:9092")
      .option("subscribe", "test")
      .option("startingOffsets", "earliest") // From starting)
      .load() //Dataframe is loaded untill here
      .selectExpr("CAST(value AS STRING) as value") //casting binary values into string
      .select(from_json(col("value"), Bands.bandsSchema).as[Bands]) //converting into the dataset with the schema we have created.
  }

  //Create your postgresql configurations
  def postgresqlSinkOptions: Map[String, String] = Map(
    "dbtable" -> "customers", // table
    "user" -> "zoe", // Database username
    "password" -> "maithi123", // Password
    "driver" -> "org.postgresql.Driver",
    "url" -> "jdbc:postgresql://localhost:5432/db"
  )

  //foreachBatch does not work with continuous mode
  //foreachBatch provides at least once guarentees while foreach provides once guarentee
  //Method to write the dataset into postgresql
  def writeToPostgresql(dataset: Dataset[Bands], mode: SaveMode = SaveMode.Append) = {
    dataset.writeStream
      .foreachBatch { (batch: Dataset[Bands], _: Long) =>
        batch.write
          .format("jdbc")
          .options(postgresqlSinkOptions)
          .mode(mode)
          .save()
      }
      .start()
      .awaitTermination()

  }

  def main(args: Array[String]): Unit = {
    run(createSparkSession())
  }

  def createSparkSession(config: Map[String, String] = Map.empty): SparkSession = {
    val spark = SparkSession
      .builder
      .master("local[4]") //[numberOfCores
      .appName("streaming-app")
      .getOrCreate()

    spark
  }

  def run(spark: SparkSession): Unit
}
package com.spark.app
import com.spark.config.SparkConfig
import com.spark.models.bands.Bands
import org.apache.spark.sql.{Dataset, SparkSession}

object PushToPostgresql extends SparkConfig {

  override def run(spark: SparkSession): Unit = {
    //reading from kafka
    val bandsDataset: Dataset[Bands] = readFromKafka(spark)
    bandsDataset.printSchema()
    //after doing something with the dataset say
    //bandsDataset.show()
    //writing to db
    writeToPostgresql(bandsDataset)
  }

}

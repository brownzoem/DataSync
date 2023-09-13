scalaVersion := "2.12.17"

val postgresVersion = "42.6.0"
val sparkVersion = "3.4.0"

libraryDependencies ++= Seq(
  //spark
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,


  //kafka
  "org.apache.spark" %% "spark-sql-kafka-0-10" % sparkVersion,

  //postgresql
  "org.postgresql" % "postgresql" % postgresVersion
)

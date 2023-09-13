package com.spark.models.bands

import org.apache.spark.sql.Encoders
import org.apache.spark.sql.types.StructType

case class Bands(first_name: String,
                 last_name: String,
                 phone_number: String,
                 address: String,
                 input_time: java.sql.Timestamp,
                 _class: String,
                 job: String,
                 age: java.lang.Integer)

object Bands {
  val bandsSchema: StructType = Encoders.product[Bands].schema
}

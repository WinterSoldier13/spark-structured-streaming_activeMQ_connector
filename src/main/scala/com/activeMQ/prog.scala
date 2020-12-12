package com.activeMQ

import org.apache.spark.sql.SparkSession

object prog
{
    val spark: SparkSession = SparkSession
        .builder()
        .appName("sampleApp")
        .master("local[*]")
        .getOrCreate()
    
//    spark.sparkContext.setLogLevel("OFF")
    import spark.implicits._
    
    def main(args : Array[String]): Unit =
    {
        val df = spark
                .readStream
                .format("org.apache.bahir.sql.streaming.mqtt.MQTTStreamSourceProvider")
                .option("brokerUrl","tcp://localhost:1883")
                .option("topic","sample_topic")
                .option("persistence","memory")
                .option("cleanSession", "true")
                .load()
                .select("payload")
                .as[Array[Byte]]
                .map(payload => new String(payload))
                .toDF("payload")
        
        df.printSchema()
        
        df
            .writeStream
            .outputMode("append")
            .format("console")
            .start
            .awaitTermination()
    
//        var data = df.selectExpr("CAST(id AS STRING)")
//
//        var query1 = data.writeStream.queryName("counting").format("memory").outputMode("append").start()
//        query1.awaitTermination()
//        for (x <- 1 to 5)
//            spark.sql("select * from counting").show()
        
        spark.stop()
        spark.close()
    }
}

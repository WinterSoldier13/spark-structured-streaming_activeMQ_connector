name := "sparkTest"

version := "0.1"

scalaVersion := "2.11.11"

val sparkVH = "2.4.0"
val sparkVL = "2.3.4"
val sparkV = sparkVH
val bahirVer = "2.4.0"

//For spark
libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core" %  sparkV,
    "org.apache.spark" %% "spark-mllib" % sparkV ,
    "org.apache.spark" %% "spark-sql" % sparkV ,
    "org.apache.spark" %% "spark-hive" % sparkV ,
    "org.apache.spark" %% "spark-streaming" % sparkV ,
    "org.apache.spark" %% "spark-graphx" % sparkV,
)

//Bahir
//libraryDependencies += "org.apache.bahir" %% "spark-sql-streaming-mqtt" % "2.3.2"
libraryDependencies += "org.apache.bahir" %% "bahir-spark-distribution" % "2.4.0"


// https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-common
libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.7.2"
libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % "2.7.2"



libraryDependencies += "org.eclipse.paho" % "org.eclipse.paho.client.mqttv3" % "1.2.5"




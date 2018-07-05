package scu.pxbd.spark1

import org.apache.spark.{SparkConf,SparkContext}

object HelloSpark {
  def main(args: Array[String]): Unit = {
    val sconf = new SparkConf().setAppName("hellospark")
    val sc = new SparkContext(sconf)

    sc.textFile(args(0)).flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).sortBy(_._2,false).saveAsTextFile(args(1))
    sc.stop()

  }

}

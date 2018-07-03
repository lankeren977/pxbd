package scu.pxbd.scala.scala_day2

object TupleDemo {
  /**
    * tuple元组用于存放不同类型的数据
    * @param args
    */
  def main(args: Array[String]): Unit = {
    var tuple_1 = (1,"hello",3.1512,6.2f)
    println(tuple_1)
    println(tuple_1._4)
  }

}

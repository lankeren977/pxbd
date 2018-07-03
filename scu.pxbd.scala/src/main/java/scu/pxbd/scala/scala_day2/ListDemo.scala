package scu.pxbd.scala.scala_day2

object ListDemo {
  def main(args: Array[String]): Unit = {
    var set = scala.collection.mutable.HashSet(3,4,5,5,5,5)
    println(set) //无顺序也不可重复
    immutable_list()
    mutable_list()
    home_work()
  }
  def immutable_list(): Unit ={
    var list = List(2,3,4,5)
    list.:+(6)
  }
  def mutable_list():Unit={
    import scala.collection.mutable.ListBuffer
    var listBuffer = ListBuffer(1,2,3,4,5)
    var listBuffer_01 = listBuffer.:+(6)
    var listBuffer_02 = listBuffer.+=:(0) //listBuffer改变
    println(listBuffer,listBuffer_01,listBuffer_02)
  }

  def home_work():Unit={
    val lines = List("hello tom hello jerry","hello mary","hello kitty")
    println("hello tom hello jerry".split(" ").toList)
    val lines_01 = lines.map(_.split(" "))
    println(lines_01) //分割第一个字符串
    val lines_02 = lines.flatMap(_.split(" "))
    println(lines_02) //先将3个字符串拆分成3个list，然后再合并成一个list
    val lines_03 = lines_02.map((_,1))
    println(lines_03)
    val group = lines_03.groupBy(_._1) //以key分组
    println(group)
    val group_01 = group.mapValues(_.foldLeft(0)(_+_._2)) //从左往右遍历value,0为初始值，以value为重复标准
    println(group_01)
  }


}

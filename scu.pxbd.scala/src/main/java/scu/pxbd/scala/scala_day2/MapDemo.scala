package scu.pxbd.scala.scala_day2

object MapDemo {

  def main(args: Array[String]): Unit = {
    immutableMap()
    mutableMap()
  }
  def immutableMap():Unit={
    import scala.collection.immutable.Map
    var map = Map('a' -> 2,('b',4)) //('b',4)为对偶数组，不可变
    var map_01 = map.+(('c' -> 8))////原始map的存储空间被遗弃，新建一个带c的map不可变集合的存储空间

    println(map('a'))
    //map('a') = 8 //在不可变集合中，不能随意更改值
    println(map)
    println(map,map_01)
  }

  def mutableMap():Unit={
    import scala.collection.mutable.Map
    var map = Map('a' -> 2,'b' -> 4)
    map.+=('a' -> 45)
    println(map)
    var map_01 = map.+(('c' -> 8))
    map('b') = 55 //可以改变
    println(map,map_01)
  }

}

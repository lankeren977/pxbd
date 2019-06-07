package scu.pxbd.scala.scala_day3

object OptionDemo extends App{
  var map = Map('a' -> 1)

  println(map.getOrElse('c',2))

}

package scu.pxbd.scala.patternmatch

import scala.util.Random

case class SubmitTask(id: String, name: String) // 样例类主要用于模式匹配
case class HeartBeat(time: Long)
case object CheckTimeOutTask

object CaseDemo06 extends App{

  //println(HeartBeat(12345).time)
  // 样例类初始化可以不用new ， 也不推荐使用new
  val arr = Array(CheckTimeOutTask, HeartBeat(1234) , SubmitTask("001","task-001"))
  //Random.nextInt(arr.length)
  val case_ = arr(Random.nextInt(arr.length)) //随机

  case_ match {
    case SubmitTask("001", name) => println(s"submittask  id ,$name ....")

    case HeartBeat(time) => println(s"heartbeat $time ...............")

    case CheckTimeOutTask => println(s"CheckTimeOutTask .............")
  }
}
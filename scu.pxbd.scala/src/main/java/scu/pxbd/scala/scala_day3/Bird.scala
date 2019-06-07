package scu.pxbd.scala.scala_day3

class Bird extends  LowAnimal with Fly  with  LuanSheng {
  println("bird............")
  override def run(): Unit = {}
} // 从new的地方忘上开始找，一直找到你的父类 ， 从最高的父类开始往下初始化，遇到with 了是从左往右初始化，最后才是初始化的Bird自己

object  Bird extends  App {
  println(new Bird())

}

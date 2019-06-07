package scu.pxbd.scala.scala_day2

object MethodDef {
  def main(args: Array[String]): Unit = {
    println(method01(2))
    println(method02(3))
    println(method03())

    recur(5)
  }
  def method01(a:Int):String={
    "hello method!"
  }

  def method02(i: Int):String={
    "hello scala!"
  }
  def method03(){
    ()
  }
  def recur(i: Int):Unit={
    if(i == 1){
      println("i=1")
    }else{
      println("step++")
      recur(i - 1)
    }
  }
  def method04(f:(Int)=> Int): Unit ={}// 把函数当成参数传递给方法

}



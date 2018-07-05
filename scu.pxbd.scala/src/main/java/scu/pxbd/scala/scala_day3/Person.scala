package scu.pxbd.scala.scala_day3

class Person {
  def this(name_1:String,gender_1:String){
    this()
    this.name = name_1
    this.gender = gender_1
    println("this is second constructor")
  }
  println("this is default constructor")
  var name:String = _
  var gender:String = _
  private var wight:Int = _ //半生对象以及自己可以访问
  private [this] var password:String = "123456" //只能自己访问

  def requestPassward (flag:Boolean): String ={
    var pass:String = if(flag) password else "不知道"
    pass
  }


}

object Person extends App {

  println("app")

  def apply(name:String ): Person ={
    new Person()
  }

  def apply(name:String ,gender:String): Person ={
    new Person(name,gender)
  }
}

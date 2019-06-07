package scu.pxbd.scala.scala_day1

object CommonType {
  def main(args: Array[String]): Unit = {

   //第一种
    var byte : Byte =12
    println("the variable byte equal " + byte)

    var char : Char = 'a'
    println("the variable char equal " + char)

    var int : Int = 484
    var float : Float = 243.1444848f //需要加上一个f

    var long : Long = 484698445
    var double : Double = 26.45456
    var short : Short = 4566
   //第二种
    var boolean : Boolean = true
    println("the variable boolean equal " + boolean)

    var string : String = "fsfdsfds"

    var unit : Unit = ()
    println("the variable unit equal " + unit)

    //第三种
    var any : Any =326
    var any_01 : Any = ""
    var any_02 : Any = 154.65465f

    var anyRef : AnyRef = "dasd"

    var anyVal : AnyVal = 56

  }

}

package scu.pxbd.scala.scala_day2

object FunctionDef {
  def main(args: Array[String]): Unit = {
    println( (a : Int ) => {a*10})

    var fuc = (a:Int, s:String , as :Int) => a*10
    print(fuc)

    var fuc_01 : Int => (Int,String) = {x=>(x,x+" ")}
    println(fuc_01)


    method04(fuc)
  }
  def method04(function: (Int, String, Int) => Int): Unit ={
    var a = function(4,"ss",6)
    println(a)
  }



}

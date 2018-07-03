package scu.pxbd.scala.scala_day2

object LoopDemo {
  def main(args: Array[String]): Unit = {
    var colloction = 1. to(10);
    println(colloction);
    var coll = 1 to 20 ;
    println(coll);
    for(a <- colloction){
      print(a);
    }

    var array = Array('a','b','c');
    for(a <- array) print(a)

    for(a <- 1 to 3 ; b <- 1 to 3 if( a != b)){
      print(a,b)
    }
    var as = for(a <- colloction if(a == 3)) yield a
    print(as)

  }

}

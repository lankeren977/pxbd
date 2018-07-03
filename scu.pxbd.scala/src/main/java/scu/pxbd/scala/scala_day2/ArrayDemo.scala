package scu.pxbd.scala.scala_day2

import scala.collection.mutable.ArrayBuffer

object ArrayDemo {
  def main(args: Array[String]): Unit = {
    arrayDef()
    arrayBufferDemo()
    arrayMethod()
  }

  def arrayDef(): Unit ={

    var arr = new Array[Int](10)
    var arr_1 = arr.+:(2) //头部追加一个2
    arr_1.++:(Array(1,2,3,4)) //头部追加一个数组
    for(a <- arr_1 ){
      println(a )
    }

    var arr_2 = Array(1,2,3,45,6)

    arr_2(2) = 1000
    for(a <- arr_2){
      println(a)
    }
  }

  def arrayBufferDemo(): Unit ={
    var arrayBuffer = new ArrayBuffer[Int](10)
    arrayBuffer.++=(Array(1,2,3,4,5)) //可变数组，不会显示后面的10个0
    println(arrayBuffer)

    var fuc = (a:Int) => a * 10
    var arrayBuffer_01 = arrayBuffer.map(fuc) //遍历数组的元素并乘10
    println(arrayBuffer_01)

    var filter_fuc = (a:Int) => a % 2 !=0 //filter可以过滤数组元素
    var arrayBuffer_02 = arrayBuffer.filter(_ % 2!=0)
    println(arrayBuffer_02)
    println(arrayBuffer)
  }

  def arrayMethod(): Unit ={
    var arr  =Array[Int](2,1,6,22,7,3,9,10)

    var arr_sort01 = arr.sortBy(_ * 5) //元素乘以5后的数据进行大小比较，排序原数据

    println(arr_sort01.toList , arr.toList) //不用循环显示数组
    var arr_sort02 = arr.sorted.reverse //倒置
    println(arr_sort02.toList)
    var arr_sort03 = arr.sortWith(_ > _) //从大到小
    println(arr_sort03.toList)
    var arr_sort04 = arr.sortWith(_ < _) //从小到大
    println(arr_sort04.toList)

  }
}

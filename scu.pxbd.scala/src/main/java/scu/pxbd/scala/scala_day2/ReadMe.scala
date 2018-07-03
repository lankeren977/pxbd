package scu.pxbd.scala.scala_day2

object ReadMe {
  def main(args: Array[String]): Unit = {
    val list0 = List(1,7,9,8,0,3,5,4,6,2)
    /**
      * 将lst0中每个元素乘以10后生成一个新的集合
      */
    val list1 = list0.map(_*10)
    println(list1)
    /**
      * 将lst0中的偶数取出来生成一个新的集合
      */
    val list2 = list0.filter(_ % 2 == 0)
    println(list2)
    /**
      * 将lst0排序后生成一个新的集合
      */
    var list3 = list0.sortWith(_ < _)
    println(list3)
    /**
      * 反转顺序
      */
    var list4 = list3.reverse
    println(list4)
    /**
      * 将lst0中的元素4个一组,类型为Iterator[List[Int]
      */
    val it = list0.grouped(4)
    println(it)
    /**
      *将Iterator转换成List
      */
    val tolist = it.toList
    println(tolist)
    /**
      *将多个list压扁成一个List
      */
    val list = tolist.flatten
    println(list)
    /**
      * 先按空格切分，在压平 , 计算每个单词的个数
      */
    val lines = List("hello tom hello jerry", "hello jerry", "hello kitty")
    val lines_01 = lines.flatMap(_.split(" "))
    println(lines_01.toList)
    val lines_02 = lines_01.map((_,1))
    val group = lines_02.groupBy(_._1)
    val group_01 = group.mapValues(_.foldLeft(0)(_+_._2))
    println(group_01)
    /**
      * 并行计算求和
      */
    var par = list0.par //并行集合
    var parSum = par.sum  //第一种方式
    println(parSum)
    var parSum2 = par.reduce(_+_) //第二种方式
    println(parSum2)
    /**
      *化简：reduce 将非特定顺序的二元操作应用到所有元素
      */
    var sum1 = list0.reduce((x,y)=>x+y)
    println(sum1)
    /**
      * 化简：reduce 按照特定的顺序
      */
    var sum2 = list0.reduceLeft(_+_)
    println(sum2)
    /**
      * 折叠：有初始值（无特定顺序） 要并行
      */
    var sum3 = list0.fold(100)((x,y)=>x+y) //100为初始值
    println(sum3)
    /**
      * 折叠：有初始值（有特定顺序） 不并行
      */
    var sum4 = list0.foldLeft(100)((x,y)=>x+y)
    println(sum4)
    /**
      * 聚合
      */
    val arr = List(List(1, 2, 3), List(3, 4, 5), List(2), List(0))
    var result = arr.aggregate(10)(seqOp,comOp)
    println(result)

    val l1 = List(5,6,4,7)
    val l2 = List(1,2,3,4)
    /**
      * 求并集
      */
    var bing = l1.union(l2).distinct//去掉重复元素
    println(bing)
    /**
      * 求交集
      */
    var jiao = l1.intersect(l2)
    println(jiao)
    /**
      * 求差集
      */
    var r3 = l1.diff(l2)
    println(r3)

    val line = List("hello tom hello jerry", "hello jerry", "hello kitty")
    var a = line.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).mapValues(_.foldLeft(0)(_+_._2))
    println(a.toList) //先按空格切分在压平,计算每个单词的个数
    var b = line.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).map(t=>(t._1, t._2.size)).toList.sortBy(_._2).reverse
    println(b) //先按空格切分，在压平，计算每个单词的个数，根据单词数量从小到大排序，再倒置







  }
  def seqOp(a:Int, b:List[Int]):Int={
    println("seqOp: " + a + "\t" + b)
    a + b.sum
  }
  def comOp(a:Int, b:Int):Int = {
    println("comOp: " + a + "\t" + b)
    a + b
  }

}

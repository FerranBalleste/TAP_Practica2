package testsc

import dataframe.CSV
import scala.jdk.CollectionConverters._

object FoldAndTabulate extends scala.App {

 //4 - Advanced Scala: fold and tabulate
  val dataframe:CSV = new CSV("testfiles/scala1.csv")

  val list1 = dataframe.getColumnAsList("IntCol").asScala.toList
  val intList = list1.map(x => x.asInstanceOf[Int])

  printf("IntCol: " + intList.toString() + "\n")
  val tab = List.tabulate(3) (n=>n*n)
  printf("Tab: " + tab.toString() + "\n")

  val combinations = for {
    i <- intList
    t <- tab
    n = i :: t :: Nil
  } yield n
  printf("All possible combinations: " + combinations.toString() + "\n")

  def add(x:Int,y:Int):Int = x+y
  def sumVector(xs:List[Int]): Int = xs.foldLeft (0) (add)
  def sumTotal(xs:List[List[Int]]): Int = {
    val ys = for {
      e <- xs
      n = sumVector(e)
    } yield n
    printf(ys.toString() + "\n")
    sumVector(ys)
  }

  printf("Total Sum: " + sumTotal(combinations) + "\n")

}

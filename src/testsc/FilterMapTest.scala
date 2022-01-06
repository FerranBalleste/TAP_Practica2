package testsc

import dataframe.CSV
import dataframe.recursion.FilterMap
import scala.jdk.CollectionConverters._

object FilterMapTest extends scala.App {

  val fm = new FilterMap

  val dataframe:CSV = new CSV("testfiles/filtermaptest.csv")
  printf(dataframe.toString)

  //Retrieve method
  val list1 = dataframe.getColumnAsList("DoubleCol").asScala.toList
  val doubleList = list1.map(x => x.asInstanceOf[Double])

  val list2 = dataframe.getColumnAsList("StringCol").asScala.toList
  val stringList = list2.map(x => x.asInstanceOf[String])


  //Round the values of a float-type column that are greater than a value (e.g.,100)
  printf("\nRound the values of a float-type column that are greater than 100 \n")
  printf("Initial: \n" + doubleList.toString + "\n")
  def round(x: Double): Long = java.lang.Math.round(x)

  val roundGreater100 = fm.listFilterMapStack[Double, Long](x => x > 100) (round) _
  val doubleResult = roundGreater100 (doubleList)
  printf("After: \n" + doubleResult.toString + "\n")


  //Replace a certain word from a string-type column on the elements that contain that word
  printf("\nReplace 'will' with 'should' from a string-type column on the elements that contain that word\n")
  printf("Initial: \n" + stringList.toString + "\n")
  def contain(s: String): Boolean = s.contains("will")
  def replace(s: String): String = s.replaceAll("will", "should")

  val replaceWill = fm.listFilterMapStack[String,String] (contain) (replace) _
  val stringResult = replaceWill (stringList)
  printf("After: \n" + stringResult.toString + "\n")

}

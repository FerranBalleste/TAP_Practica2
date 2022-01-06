package testsc

import dataframe.CSV
import dataframe.composite.Directory
import dataframe.visitors.FilterVisitor
import table.Row

object FilterVisitorTest extends scala.App {


  val dir1 = new Directory("root")
  dir1.addChild(new CSV("testfiles/scala1.csv")) //scala1.csv --> 3 columns, 10 elements
  dir1.addChild(new CSV("testfiles/scala2.csv")) //scala1.csv --> 3 columns, 8 elements
  val dir2 = new Directory("child")
  dir2.addChild(new CSV("testfiles/scala2.csv"))
  dir1.addChild(dir2)

  case class LessThan(x: Int)(col: Int) extends Function[Row, Boolean] {
    def apply(row: Row): Boolean = row.getElement(col).getValue.asInstanceOf[Int] < x
  }

  val v = new FilterVisitor(LessThan(5)(0))
  dir1.accept(v)
  println("Filtered (first column, less than 5): \n" + v.elements + "\n")

  val dir3 = new Directory("child")
  dir3.addChild(new CSV("testfiles/scala1.csv"))
  dir2.addChild(dir3)

  val v2 = new FilterVisitor(LessThan(2)(0))
  dir1.accept(v2)
  println("Filtered (first column, less than 2): \n" + v2.elements + "\n")

  //4 - Advanced Scala: For Loops
  //Obtains strings starting with today on the first result
  val z = for {
    e <- v.elements
    n = e.getElement(2).getValue.asInstanceOf[String]
    if n startsWith "Today"
  } yield n

  println(z)

}

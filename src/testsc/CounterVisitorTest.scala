package testsc

import dataframe.CSV
import dataframe.composite.Directory
import dataframe.visitors.{CounterVisitor, MessageMultipleInheritance}

object CounterVisitorTest extends scala.App {

  val dir1 = new Directory("root")
  dir1.addChild(new CSV("testfiles/scala1.csv")) //scala1.csv --> 3 columns, 10 elements
  dir1.addChild(new CSV("testfiles/scala2.csv")) //scala1.csv --> 3 columns, 8 elements
  val dir2 = new Directory("child")
  dir2.addChild(new CSV("testfiles/scala2.csv"))
  dir1.addChild(dir2)

  val c = new CounterVisitor() with MessageMultipleInheritance  // 4 - Advanced Scala: Runtime multiple inheritance
  printf(c.message())
  dir1.accept(c)
  println("Expected => DataFrame files: " + 3 + " DataFrame dirs: " + 2)
  println("Result   => DataFrame files: " + c.files + " DataFrame dirs: " + c.dirs)

  val dir3 = new Directory("child2")
  dir3.addChild(new CSV("testfiles/scala2.csv"))
  dir3.addChild(new CSV("testfiles/scala2.csv"))
  dir3.addChild(new CSV("testfiles/scala2.csv"))
  dir2.addChild(dir3)
  val c2 = new CounterVisitor()
  dir1.accept(c2)
  println("Expected => DataFrame files: " + 6 + " DataFrame dirs: " + 3)
  println("Result   => DataFrame files: " + c2.files + " DataFrame dirs: " + c2.dirs)

}

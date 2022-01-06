package testsc

import dataframe.CSV
import dataframe.composite.Directory

object CompositeTest extends scala.App {
  val dir1 = new Directory("root")
  dir1.addChild(new CSV("testfiles/scala1.csv")) //scala1.csv --> 3 columns, 10 elements
  //printf(dir1.toString)
  printf("Size -> Expected: 10, Result: " + dir1.size.toString + "\n")
  printf("Columns -> Expected: 3, Result: " + dir1.columns.toString + "\n")

  dir1.addChild(new CSV("testfiles/scala2.csv")) //scala1.csv --> 3 columns, 8 elements
  printf("Size -> Expected: 18, Result: " + dir1.size.toString + "\n")
  printf("Columns -> Expected: 3, Result: " + dir1.columns.toString + "\n")

  printf("id 0, IntCol -> Expected: 1, Result: " + dir1.at(0, "IntCol") + "\n")
  printf("id 1, IntCol -> Expected: 2, Result: " + dir1.at(1, "IntCol") + "\n")
  printf("id 9, IntCol -> Expected: 10000, Result: " + dir1.at(9, "IntCol") + "\n")
  printf("id 10, IntCol -> Expected: 1, Result: " + dir1.at(10, "IntCol") + "\n")
  printf("id 11, IntCol -> Expected: 2, Result: " + dir1.at(11, "IntCol") + "\n")

  val dir2 = new Directory("child")
  dir2.addChild(new CSV("testfiles/scala2.csv"))
  dir1.addChild(dir2)
  printf("Size -> Expected: 26, Result: " + dir1.size.toString + "\n")
  printf("Columns -> Expected: 3, Result: " + dir1.columns.toString + "\n")
  printf("id 20, IntCol -> Expected: 3, Result: " + dir1.at(20, "IntCol") + "\n")


}

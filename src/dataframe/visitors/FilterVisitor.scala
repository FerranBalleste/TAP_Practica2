package dataframe.visitors
import dataframe.IDataFrame
import table.Row
import dataframe.composite.{AComponent, Directory}

import scala.jdk.CollectionConverters._
import scala.collection.mutable.ListBuffer

/**
 * Collects all elements (rows) that fulfill a condition. Like the query operation.
 * see testsc.FilterVisitorTest
 * @param p Row predicate
 */
class FilterVisitor(p: Row => Boolean) extends AVisitor{

 var elements: ListBuffer[Row] = new ListBuffer[Row]()

  def visit(c:AComponent): Unit = c match {
    case dir : Directory =>
      dir.children.foreach(child => visit(child))
    case dat : IDataFrame =>
      elements = elements ++ dat.getRowList.asScala.to(ListBuffer).filter(p)
  }
}

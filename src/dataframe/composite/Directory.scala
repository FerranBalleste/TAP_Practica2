package dataframe.composite
import dataframe.visitors.AVisitor
import table.element.TableElement

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/**
 * Directory class in scala
 * @param name Name of the directory
 */
class Directory(val name:String) extends AComponent {
  var children: ListBuffer[AComponent] = new ListBuffer[AComponent]()

  /**
   * Add a child to the directory
   * @param child child
   */
  def addChild(child: AComponent): Unit = {
    children += child
  }

  /**
   * Removes a child from the directory
   * @param child child
   */
  def removeChild(child: AComponent): Unit = {
    children -= child
  }

  /*                    */
  /* IComponent Methods */
  /*                    */

  /**
   * Returns the value of a single item by row and columName from a Composite
   *
   * @param id    row (from 0 to the sum of all component sizes -1)
   * @param label columnName
   * @return TableElement on that position, if not found returns null
   */
  def at(id: Int, label: String): TableElement = findComponentAt(id, label, children)

  @tailrec
  private def findComponentAt(row: Int, label: String, list: ListBuffer[AComponent]): TableElement = {
    val size = list.head.size
    if (row < size) return list.head.at(row, label)
    findComponentAt(row - size, label, list.drop(1))
  }

  /**
   * Number of columns (number of labels)
   *
   * @return number of columns of the first child dataframe
   */
  def columns: Int = children.head.columns

  /**
   * Number of elements (number of rows without counting the labels)
   *
   * @return number of elements
   */
  def size: Int = children.map(_.size).sum

  /**
   * Method needed to implement a visitor pattern
   *
   * @param visitor IVisitor element
   */
  override def accept(visitor: AVisitor): Unit = {
    //children.foreach(c => c.accept(visitor))
    visitor.visit(this)
  }

  override def toString: String = {
    printf("Directory: " + name + "{\n")
    children.foreach(c => printf(c.toString))
    printf("}")
    ""
  }
}

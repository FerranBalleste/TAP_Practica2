package dataframe.composite

import dataframe.visitors.AVisitor
import table.element.TableElement

trait AComponent {
  def at(id: Int, label: String):TableElement
  def size:Int
  def columns:Int
  def accept(visitor:AVisitor): Unit = visitor.visit(this)
}
package dataframe.visitors

import dataframe.IDataFrame
import dataframe.composite.{AComponent, Directory}

/**
 * Counts the number of files and directories it has visited
 */
class CounterVisitor() extends AVisitor {

  var files: Int = 0
  var dirs: Int = 0

  def visit(c:AComponent): Unit  = c match{
      case dir : Directory =>
        dirs = dirs + 1
        dir.children.foreach(c => visit(c))
      case _: IDataFrame =>
        files = files + 1
  }
}

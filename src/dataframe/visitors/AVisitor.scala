package dataframe.visitors

import dataframe.composite.AComponent

/**
 * Trait extended by visitors
 */
trait AVisitor {
 def visit(c:AComponent): Unit
}

/**
 * Trait to show runtime multiple inheritance in testsc.CounterVisitorTest
 */
trait MessageMultipleInheritance {
 def message():String = "This is a visitor \n"
}

# TAP_Practica2
<p>https://github.com/FerranBalleste/TAP_Practica2</p>
06/01/2022
Ferran Balleste Solsona: ferran.balleste@estudiants.urv.cat

<p>We will use the Java code of the first part of the Java assignment to create a layer in Scala that interacts with 
our DataFrame library.</p>
<p>To see dataframe documentation go to: (https://github.com/FerranBalleste/TAP_Practica1/tree/master)<p>

## Composite
<p>A scala implementation with the operations: at, columns and size has been added in: (https://github.com/FerranBalleste/TAP_Practica2/tree/master/src/dataframe/composite)</p>

## Visitor
<p>A visitor pattern combined with the composide has been added in: (https://github.com/FerranBalleste/TAP_Practica2/tree/master/src/dataframe/visitors)</p>
<p>Two visitors have been implemented: FilterVisitor (collects all elementsthat fulfill a condition(query)) and CounterVisitor (counts the number of files and directories)</p>

## Recursion
<p>A function listFilterMap that filters the elements in a list based on a given condition and applies an operation to those that fulfill it has been added in:
https://github.com/FerranBalleste/TAP_Practica2/tree/master/src/dataframe/recursion</p>

<p>Codes that test the functionality: (https://github.com/FerranBalleste/TAP_Practica2/tree/master/src/testsc)</p>

## Advanced scala
<p>Demonstrate using ScalaDataFrame the use of the following advanced features of Scala:</p>
<p>Runtime multiple inheritance: https://github.com/FerranBalleste/TAP_Practica2/blob/master/src/testsc/CounterVisitorTest.scala<p>
<p>For loops (inside the code there are several for operations, a more complex one has been added in: https://github.com/FerranBalleste/TAP_Practica2/blob/master/src/testsc/FilterVisitorTest.scala)</p>
<p>Fold, tabulate: (https://github.com/FerranBalleste/TAP_Practica2/blob/master/src/testsc/FoldAndTabulate.scala)</p>
<p>Curry, partial parametrization: (https://github.com/FerranBalleste/TAP_Practica2/blob/master/src/testsc/FilterMapTest.scala)</p>

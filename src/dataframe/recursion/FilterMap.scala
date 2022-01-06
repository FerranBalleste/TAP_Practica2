package dataframe.recursion


import scala.annotation.tailrec
/**
 * Filters the elements in a list based on a given condition and applies an operation to those that fulfill it.
 * Combination of filter and map.
 *
 */
class FilterMap {
 /*
  def listFilterMapStack2[A,B](list: List[A]) (pred: A => Boolean) (f: A => B): List[B] = {
    val filtered = filterStack[A](list) (pred)
    mapStack[A,B](filtered) (f)
  }

  def mapStack[A,B](list: List[A]) (f: A => B): List[B] = list match {
    case Nil => Nil
    case x :: xs => f(x) :: mapStack[A,B](xs) (f)
  }

  def filterStack[A](list: List[A]) (pred: A => Boolean): List[A] = list match {
    case Nil => Nil
    case x :: xs => {
      if (pred(x))  x :: filterStack[A](xs)(pred)
      else          filterStack[A](xs)(pred)
    }
  }
*/

  /**
   * Filters the elements in a list based on a given condition and applies an operation to those that fulfill it. (Stack Recursive)
   * @param pred Condition
   * @param f Function that will be applied
   * @param list Input list
   * @tparam A Input Generic
   * @tparam B Output Generic
   * @return Filtered list with the function applied
   */
  def listFilterMapStack[A,B] (pred: A => Boolean) (f: A => B) (list: List[A]): List[B] = list match {
    case Nil => Nil
    case x :: xs =>
      if (pred(x))  f(x) :: listFilterMapStack[A,B] (pred) (f) (xs)
      else          listFilterMapStack[A,B] (pred) (f) (xs)
  }

  /**
   * Filters the elements in a list based on a given condition and applies an operation to those that fulfill it. (Tail Recursive)
   * @param pred Condition
   * @param f Function that will be applied
   * @param list Input list
   * @tparam A Input Generic
   * @tparam B Output Generic
   * @return Filtered list with the function applied
   */
  def listFilterMapTail[A,B](list: List[A]) (pred: A => Boolean) (f: A => B): List[B] = {
    @tailrec
    def mapAccumulator(list:List[A]) (accList: List[B]) : List[B] = list match{
      case Nil => accList
      case x :: xs =>
        if(pred(x)) mapAccumulator (xs.drop(1)) (f(xs.head) :: accList)
        else        mapAccumulator (xs.drop(1)) (accList)
    }
    mapAccumulator (list) (Nil)
  }

}

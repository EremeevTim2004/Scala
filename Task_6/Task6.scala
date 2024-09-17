import scala.annotation.tailrec
import scala.collection.immutable
import scala.BigInt
import scala.math.*
import scala.util.*

@main def task6(): Unit = {
  // ----TASK 1
  def pack[T](xs: List[T]): List[List[T]] = {
    // ...
  }

  // ----TASK 2
  def encode1[T](xs: List[T]): List[(T, Int)] = {
    // ...
  }

  // ----TASK 3
  def encode2[T](xs: List[T]): List[(T, Int)] = {
    // ...
  }

  println("TASK1")
  val list = List("a", "a", "a", "b", "b", "a")
  println(pack(list))
  println("TASK2")
  val list = List("a", "a", "a", "b", "b", "a")
  println(encode1(list))
  println("TASK3")
  val list = List("a", "a", "a", "b", "b", "a")
  println(encode2(list))
}

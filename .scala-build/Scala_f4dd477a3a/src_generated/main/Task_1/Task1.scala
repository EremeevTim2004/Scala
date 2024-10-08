package Task_1


final class Task1$_ {
def args = Task1_sc.args$
def scriptPath = """Task_1/Task1.sc"""
/*<script>*/
import scala.math._
import BigInt.probablePrime
import util.Random

// 1 Вычислите квадратный корень из 3, а затем возведите результат в квадрат.
// Насколько окончательный результат отличается от 3?
println(3 - pow(sqrt(3), 2))

// 2 Язык Scala позволяет умножать строки на числа – попробуйте выполнить выражение "csit" * 3.
// Что получилось в результате?
"csit" * 3

// 3 Что означает выражение 10 max 2? В каком классе определен метод max?
10 max 2
// Определено в RichInt

// 4 Используя число типа BigInt , вычислите 2^{1024}.
BigInt(2) pow 1024

// 5 Что нужно импортировать, чтобы найти случайное простое число вызовом метода probablePrime(100, Random)
// без использования каких-либо префиксов перед именами probablePrime и Random ?
probablePrime(100, Random)

// 6 Как получить первый и последний символ строки в языке Scala?
val s = "csit"
s.head
s(0)
s.last
s(s.length - 1)

// 7 Что делают строковые функции take , drop , takeRight и dropRight? Приведите примеры
// take: Берет n первыъ элементов
s.take(2)
// drop: Берет все элементы кроме первых n
s.drop(2)
// takeRight: Берет n элементов с конца
s.takeRight(2)
// dropRight: Берет n элементов кроме n с конца
s.dropRight(2)

/*</script>*/ /*<generated>*//*</generated>*/
}

object Task1_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new Task1$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export Task1_sc.script as `Task1`


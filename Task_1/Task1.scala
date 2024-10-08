import scala.math._
import BigInt.probablePrime
import util.Random

// 1 Вычислите квадратный корень из 3, а затем возведите результат в квадрат.
// Насколько окончательный результат отличается от 3?
@main def task1_1(): Unit = {
    println(3 - pow(sqrt(3), 2))
}

// 2 Язык Scala позволяет умножать строки на числа – попробуйте выполнить выражение "csit" * 3.
// Что получилось в результате?
@main def task1_2(): Unit = {
    println("csit" * 3)
}

// 3 Что означает выражение 10 max 2? В каком классе определен метод max?
// Определено в RichInt
@main def task1_3(): Unit = {
    println(10 max 2)
}

// 4 Используя число типа BigInt, вычислите 2^{1024}.
@main def task1_4(): Unit = {
    println(BigInt(2).pow(1024))
}


// 5 Что нужно импортировать, чтобы найти случайное простое число вызовом метода probablePrime(100, Random)
// без использования каких-либо префиксов перед именами probablePrime и Random?
@main def task1_5(): Unit = {
    println(probablePrime(100, Random))
}

// 6 Как получить первый и последний символ строки в языке Scala?
@main def task1_6(): Unit = {
    val s = "csit"
    println(s.head) // первый символ
    println(s(0))   // первый символ
    println(s.last) // последний символ
    println(s(s.length - 1)) // последний символ
}

// 7 Что делают строковые функции take, drop, takeRight и dropRight? Приведите примеры
@main def task1_7(): Unit = {
    val s = "csit"
    // take: Берет n первых элементов
    println(s.take(2))
    // drop: Берет все элементы кроме первых n
    println(s.drop(2))
    // takeRight: Берет n элементов с конца
    println(s.takeRight(2))
    // dropRight: Берет все элементы кроме n с конца
    println(s.dropRight(2))
}
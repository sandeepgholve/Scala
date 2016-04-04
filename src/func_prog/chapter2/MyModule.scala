package func_prog.chapter2

object MyModule {
  def abs(num: Int): Int = {
    if (num < 0) -num
    else num
  }

  def factorial(num: Int): Int = {
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n-1, n*acc)
    }

    go(num, 1)
  }

  /**
    * Calculating nth Fibonacci number.
    * @param num position of nth Number in the Fibonacci Series.
    * @return nth Number in the Fibonacci Series.
    */
  def fibonacci(num: Int): Int = {
    def go(count: Int, first: Int, second: Int): Int = {
      if (count == 0) first
      else go(count-1, second, first+second)
    }

    if (num == 0) 0
    else go(num-1, 0, 1)
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
  }

}
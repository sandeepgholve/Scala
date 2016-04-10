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

    go(num, 0, 1)
  }
  
  def fib(n: Int): Int = {
    def go(first: Int, second: Int, count: Int): Int = {
      if (count <= 0) first
      else go(second, first + second, count-1)
    }
    go(0, 1, n-1)
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  private def formatFactorial(n: Int) = {
    val msg = "The factorial of %d is %d"
    msg.format(n, factorial(n))
  }
  
  private def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d."
    msg.format(name, n, f(n))
  }

  def main(args: Array[String]): Unit = {
    println(formatResult("absolute value", -42, abs))
    println(formatResult("factorial", 5, factorial))
    println(formatResult("nth Fibonacci number ", 5, fib))
  }

}
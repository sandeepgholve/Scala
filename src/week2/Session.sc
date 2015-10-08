object Session {
  println("Welcome to the Scala - Higher Order Function")
  // Id Function
  def id(x: Int): Int = x

  // Cube Function
  def cube(x: Int): Int = x * x * x

  // Factorial Function
  def factorial(x: Int): Int = {
    def loop(accumulator: Int, x: Int): Int =
      if (x == 0) accumulator else loop(accumulator * x, x - 1)

    loop(1, x)
  }

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a+1, b)

  def sumOfNumbers(a: Int, b: Int) = sum((x: Int) => x, a, b)
  def sumOfCubes(a: Int, b: Int) = sum((x) => x*x*x, a, b)
  def sumOfFactorials(a: Int, b: Int) = sum(factorial, a, b)

  def sum1(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a+1, f(a)+acc)
    }
    loop(a, 0)
  }


  sumOfCubes(2, 3)
  sum1((x: Int) => x*x*x)(2, 3)
  sumOfNumbers(2, 3)
  sumOfFactorials(2, 3)
}
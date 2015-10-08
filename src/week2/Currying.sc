object Currying {
  println("Welcome to the Scala worksheet")

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(x: Int, y: Int): Int =
      if (x>y) 0
      else f(x) + sumF(x+1, y)
    sumF
  }

  def sum1(f: Int => Int) (a: Int, b: Int): Int = {
    if (a>b) 0
    else f(a) + sum1(f)(a+1, b)
  }

  def sumOfInts = sum(x => x)
  def sumOfCubes = sum(x => x*x*x)

  sumOfInts(1,10)
  sumOfCubes(2,3)

  sum1 (x => x*x*x) (2, 3)
}
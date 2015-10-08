import week1.Person
object session {
  println("Hello Scala")
  val person = new Person("Sandeep Gholve", 32)
  print(person)
  println("Welcome to the Scala worksheet")

  def sqrt(x: Double): Double = {

    def abs(x: Double): Double = if (x < 0) -x else x
    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    def improve(guess: Double, x: Double) =
      (guess + x / guess) / 2

    def isGoodEnough(guess: Double, x: Double) =
      abs(guess * guess - x) / x < 0.001

    sqrtIter(1.0, x)
  }

  sqrt(2)
  sqrt(4)
  sqrt(1e60)
  sqrt(1e-6)
  sqrt(16)
}

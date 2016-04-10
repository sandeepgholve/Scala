import week1.Person
object session {
  println("Hello Scala")                          //> Hello Scala
  val person = new Person("Sandeep Gholve", 32)   //> person  : week1.Person = Name: Sandeep Gholve, Age: 32
  print(person)                                   //> Name: Sandeep Gholve, Age: 32
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	// Version #1
  def sqrt_v1(x: Double): Double = {

    def abs(x: Double): Double = if (x < 0) -x else x
    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    def improve(guess: Double, x: Double) =
      (guess + x / guess) / 2

    def isGoodEnough(guess: Double, x: Double) =
      abs(guess * guess - x) / x < 0.001

    sqrtIter(1.0, x)
  }                                               //> sqrt_v1: (x: Double)Double

	// Version #2 .. here we don't need to pass x to inner functions as its by default available
  def sqrt_v2(x: Double): Double = {

    def abs(x: Double): Double = if (x < 0) -x else x
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def improve(guess: Double) =
      (guess + x / guess) / 2

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    sqrtIter(1.0)
  }                                               //> sqrt_v2: (x: Double)Double

  sqrt_v1(2)                                      //> res0: Double = 1.4142156862745097
  sqrt_v1(4)                                      //> res1: Double = 2.000609756097561
  sqrt_v1(1e60)                                   //> res2: Double = 1.0000788456669446E30
  sqrt_v1(1e-6)                                   //> res3: Double = 0.0010000001533016628
  sqrt_v1(16)                                     //> res4: Double = 4.000000636692939
  sqrt_v2(2)                                      //> res5: Double = 1.4142156862745097
  sqrt_v2(4)                                      //> res6: Double = 2.000609756097561
  sqrt_v2(1e60)                                   //> res7: Double = 1.0000788456669446E30
  sqrt_v2(1e-6)                                   //> res8: Double = 0.0010000001533016628
  sqrt_v2(16)                                     //> res9: Double = 4.000000636692939
}
package week1

object Session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

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
  }                                               //> sqrt: (x: Double)Double
  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  sqrt(4)                                         //> res1: Double = 2.000609756097561
  sqrt(1e60)                                      //> res2: Double = 1.0000788456669446E30
  sqrt(1e-6)                                      //> res3: Double = 0.0010000001533016628
  sqrt(16)                                        //> res4: Double = 4.000000636692939
}
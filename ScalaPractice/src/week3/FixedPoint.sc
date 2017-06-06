import math.abs

object FixedPoint {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  
  def isCloseEnough(x: Double, y: Double) =
  	abs((x - y) / x) / x < tolerance          //> isCloseEnough: (x: Double, y: Double)Boolean
  	
  def fixedPoint(f: Double => Double) (firstGuess: Double) = {
  	def iterate(guess: Double): Double = {
  		//println("guess: " + guess)
  		val next = f(guess)
  		if (isCloseEnough(guess, next)) next
  		else iterate(next)
  	}
  	iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x))/ 2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
  
  fixedPoint(x => 1 + x/2)(1)                     //> res0: Double = 1.999755859375
  
  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1)
                                                  //> sqrt: (x: Double)Double
  
  def sqrt1(x: Double) =
  	fixedPoint(averageDamp(y => x/y))(1)      //> sqrt1: (x: Double)Double
  sqrt(2)                                         //> res1: Double = 1.4142135623746899
  sqrt1(2)                                        //> res2: Double = 1.4142135623746899
}
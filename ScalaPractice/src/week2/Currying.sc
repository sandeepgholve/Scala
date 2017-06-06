package week2

object Currying {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def sum(f: Int => Int): (Int, Int) => Int = {
  	def sumF(x: Int, y: Int): Int =
  		if (x>y) 0
  		else f(x) + sumF(x+1, y)
  	sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int
  
  def sum1(f: Int => Int) (a: Int, b: Int): Int = {
  	if (a>b) 0
  	else f(a) + sum1(f)(a+1, b)
  }                                               //> sum1: (f: Int => Int)(a: Int, b: Int)Int
  
  def sumOfInts = sum(x => x)                     //> sumOfInts: => (Int, Int) => Int
  def sumOfCubes = sum(x => x*x*x)                //> sumOfCubes: => (Int, Int) => Int
  
  sumOfInts(1,10)                                 //> res0: Int = 55
  sumOfCubes(2,3)                                 //> res1: Int = 35
  
  sum1 (x => x*x*x) (2, 3)                        //> res2: Int = 35
}
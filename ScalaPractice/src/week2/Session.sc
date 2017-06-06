package week2

object Session {
  println("Welcome to the Scala - Higher Order Function")
                                                  //> Welcome to the Scala - Higher Order Function
  // Id Function
  def id(x: Int): Int = x                         //> id: (x: Int)Int

  // Cube Function
  def cube(x: Int): Int = x * x * x               //> cube: (x: Int)Int

  // Factorial Function
  def factorial(x: Int): Int = {
    def loop(accumulator: Int, x: Int): Int =
      if (x == 0) accumulator else loop(accumulator * x, x - 1)

    loop(1, x)
  }                                               //> factorial: (x: Int)Int
  
  def sum(f: Int => Int, a: Int, b: Int): Int =
  	if (a > b) 0
  	else f(a) + sum(f, a+1, b)                //> sum: (f: Int => Int, a: Int, b: Int)Int
  	
  def sumOfNumbers(a: Int, b: Int) = sum((x: Int) => x, a, b)
                                                  //> sumOfNumbers: (a: Int, b: Int)Int
  def sumOfCubes(a: Int, b: Int) = sum((x) => x*x*x, a, b)
                                                  //> sumOfCubes: (a: Int, b: Int)Int
  def sumOfFactorials(a: Int, b: Int) = sum(factorial, a, b)
                                                  //> sumOfFactorials: (a: Int, b: Int)Int

  def sum1(f: Int => Int)(a: Int, b: Int): Int = {
  	def loop(a: Int, acc: Int): Int = {
  		if (a > b) acc
  		else loop(a+1, f(a)+acc)
  	}
  	loop(a, 0)
  }                                               //> sum1: (f: Int => Int)(a: Int, b: Int)Int


	sumOfCubes(2, 3)                          //> res0: Int = 35
	sum1((x: Int) => x*x*x)(2, 3)             //> res1: Int = 35
	sumOfNumbers(2, 3)                        //> res2: Int = 5
	sumOfFactorials(2, 3)                     //> res3: Int = 8
}
package week2

object Exercise {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)              //> product: (f: Int => Int)(a: Int, b: Int)Int
    
	def product1(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x*y, 1)(a, b)
                                                  //> product1: (f: Int => Int)(a: Int, b: Int)Int

	// Factorial in terms of Product
  def factorial(n: Int): Int = product(x => x)(1, n)
                                                  //> factorial: (n: Int)Int

  def factorial1(n: Int): Int = product1(x => x)(1, n)
                                                  //> factorial1: (n: Int)Int

 	// Generalize Sum and Product
 	def mapReduce(f: Int => Int, combine: (Int, Int) => Int, initial: Int)(a: Int, b: Int): Int =
 		if (a > b) initial
 		else combine(f(a), mapReduce(f, combine, initial)(a+1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, initial: Int)(a: Int,
                                                  //|  b: Int)Int

  product(x => x)(3, 7)                           //> res0: Int = 2520
  product(x => x * x)(3, 7)                       //> res1: Int = 6350400
  
  factorial(5)                                    //> res2: Int = 120
  factorial1(5)                                   //> res3: Int = 120
  
  product1(x => x)(3, 7)                          //> res4: Int = 2520
}
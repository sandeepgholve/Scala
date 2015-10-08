object Exercise {
  println("Welcome to the Scala worksheet")

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)

  def product1(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x*y, 1)(a, b)

  // Factorial in terms of Product
  def factorial(n: Int): Int = product(x => x)(1, n)

  def factorial1(n: Int): Int = product1(x => x)(1, n)

  // Generalize Sum and Product
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, initial: Int)(a: Int, b: Int): Int =
    if (a > b) initial
    else combine(f(a), mapReduce(f, combine, initial)(a+1, b))

  product(x => x)(3, 7)
  product(x => x * x)(3, 7)

  factorial(5)
  factorial1(5)

  product1(x => x)(3, 7)
}
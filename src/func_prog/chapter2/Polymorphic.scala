package func_prog.chapter2

/**
  * Created by sgholve on 04.04.16.
  */

object Polymorphic {
  def main(args: Array[String]) {
    val polymorphic = new Polymorphic()

    val names = Array("Sandeep", "Kundlik", "Gholve")
    val ages = Array(25, 31, 40)

    val msg1 = "Position of Sandeep: %d"
    val msg2 = "Position of 31: %d"
    println(msg1.format(polymorphic.findFirst(names, (name: String) => name == "Sandeep")))
    println(msg2.format(polymorphic.findFirst(ages, (x: Int) => x == 31)))

    val intArr = Array(1,2,3,4)
    println(polymorphic.isSorted(intArr, (x: Int, y: Int) => x > y))
  }
}

class Polymorphic {

  def findFirst[A](as: Array[A], f: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n >= as.length) -1
      else if (f(as(n))) n
      else loop(n+1)
    }

    loop(0)
  }

  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n: Int): Boolean = {
      if (n >= as.length-1) true
      else if (gt(as(n), as(n+1))) false
      else loop(n+1)
    }

    loop(0)
  }

  def partial1[A,B,C](a: A, f: (A,B) => C): B => C = {
    (b: B) => f(a, b)
  }

  // Note that `=>` associates to the right, so we could
  // write the return type as `A => B => C`
  def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a, b)
  }

  def uncurry[A,B,C](f: A => (B => C)): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }

  def compose[A,B,C](f: B => C, g: A => B): A => C = {
    (a: A) => f(g(a))
  }
}

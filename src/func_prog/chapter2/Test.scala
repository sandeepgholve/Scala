package func_prog.chapter2

object Test {
  def main(args: Array[String]) {
    val a = -42
    println(MyModule.abs(a))
    println("Hello Scala")
    println(MyModule.fibonacci(8))
    val num = 5
    val msg = "Factorial of %d is %d"
    println(msg.format(num, MyModule.factorial(num)))
  }
}
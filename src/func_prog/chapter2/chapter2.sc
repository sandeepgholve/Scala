package func_prog.chapter2;

object chapter2 {
  val a = -42                                     //> a  : Int = -42
  println(MyModule.abs(a))                        //> 42
  println("Hello Scala")                          //> Hello Scala
  val num = 5                                     //> num  : Int = 5
  val msg = "Factorial of %d is %d"               //> msg  : String = Factorial of %d is %d
  msg.format(num, MyModule.factorial(num))        //> res0: String = Factorial of 5 is 120
  // sandeep
}
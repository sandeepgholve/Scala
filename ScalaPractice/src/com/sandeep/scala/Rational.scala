package com.sandeep.scala

class Rational(n: Int, d: Int) {
  require(d != 0)
  val numer: Int = n
  val denom: Int = d
  
  def this(n: Int) = this(n, 1) // Auxiliary constructor
  
  override def toString = numer + "/" + denom
  
  def add(that: Rational): Rational =
    new Rational(
        this.numer * that.denom + that.numer * this.denom,
        this.denom * that.denom
    )

  def lessThan(that: Rational) =
    this.numer * that.denom < that.numer * this.denom
  
  def max(that: Rational) =
    if (this.lessThan(that)) that else this
    
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a%b)
}
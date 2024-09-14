package com.shakik

object FunctionalProgramming extends App {
  class Person(name: String):
    def apply(age: Int): Unit = println(s"I have aged $age years")

  val bob = new Person("Bob")
  bob.apply(19)
  bob(19)   // bob() == bob.apply()
  /*
  Why is it?
  In FP we want to work with functions as First-class citizens
  means we want to work with functions just like any other values/objects
    - compose functions
    - pass functions as arg
    - return functions as results

  conclusion: FunctionX
  Scala provides a series of traits (Function0 through Function22) to represent functions
  that take anywhere from zero to 22 parameters. For example:
  --> Function0 is for functions with no parameters (() => R).
  --> Function2 is for functions with two parameters ((A, B) => C), and so on.
  The square brackets ([]) are used in Scala to pass type parameters to generic types
  example:
  // Syntax for FunctionX traits
  */
  val simpleAdder: (Double, Double) => Double = new Function2[Double, Double, Double]:  // Creates a Fn1 class Instance
    override def apply(v1: Double, v2: Double): Double = v1 + v2
  assert(simpleAdder(12, 2) == 14.0)

  /*
  This approach is backdated tho
  A cleaner approach is using ANONYMOUS **CLASSES**
  example
  */
  val simpleIncrementer = new (Int => Int):
    override def apply(v1: Int): Int = v1 + 1
  assert(simpleIncrementer(18) == 19)

  /*
  However there is another approach ANONYMOUS **FUNCTION** very similar to LAMBDA
  example:
  */
  val simpleMultiplier: (Int, Int) => Long = (v1: Int, v2: Int) => v1 * v2    // (Int, Int) => Long == Function2[Int, Int, Long]
  assert(simpleMultiplier(10, 10).isValidLong)

  /*
  HIGHER ORDER ARGS
  - takes fn as arg
  - returns fn as result
   */


}

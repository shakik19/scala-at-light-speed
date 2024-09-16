package com.shakik

import scala.::

object FunctionalProgramming extends App {
  class Person(name: String):
    def apply(age: Int): Unit = println(s"I have aged $age years")

  val bob = new Person("Bob")
  bob.apply(19)
  bob(19)   // bob() == bob.apply()
  /**
  Why is it?
  In FP we want to work with functions as First-class citizens
  means we want to work with functions just like any other values/objects
    - compose functions
    - pass functions as arg
    - return functions as results

  *! FunctionX
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

  /**
   * ? ANONYMOUS CLASSES
  This approach is backdated tho
  A cleaner approach is using ANONYMOUS **CLASSES**
  example
  */
  val simpleIncrementer = new (Int => Int):
    override def apply(v1: Int): Int = v1 + 1
  assert(simpleIncrementer(18) == 19)

  /**
   * ? ANONYMOUS FUNCTION
  However there is another approach ANONYMOUS **FUNCTION** very similar to LAMBDA
  example:
  */
  val simpleMultiplier: (Int, Int) => Long = (v1: Int, v2: Int) => v1 * v2    // (Int, Int) => Long == Function2[Int, Int, Long]
  assert(simpleMultiplier(10, 10).isValidLong)

  /**
  *! HIGHER ORDER ARGS
  - takes fn as arg
  - returns fn as result
   */

  /**
   *? REGULAR MAP
   */
  val aMappedList = List(2, 4, 6).map(x => 2 * x)
  assert(aMappedList == List(4, 8, 12))

  /**
  *? FLATMAP
  What flatmap actually does is uses the given function and applies it to every element
  on the given Seq/Iterable and makes a new list following the given signature and then
  concat all the generated list to produce a single one
   */
  val aFlatMappedList = List(1, 2, 3).flatMap(x => List(x*x))
  assert(aFlatMappedList == List(1, 4, 9))
  val aFlatMappedList2 = List(1, 2, 3).flatMap(x => List(x, x*x))
  assert(aFlatMappedList2 == List(1, 1, 2, 4, 3, 9))
  // Alternative syntax
  val aFlatMappedList3 = List(1, 2, 3).flatMap{x =>
    List(x, x*x)
  }
  assert(aFlatMappedList3 == List(1, 1, 2, 4, 3, 9))

  /**
   * ? FILTER
   */
  val aFilteredList = List.range(0, 5).filter(x => x % 2 == 0)   // Filters only EVEN numbers
  val aFilteredList2 = List.range(0, 5).filter(_ % 2 == 0)   // '_' means x => x
  assert(aFilteredList == List(0, 2, 4))

  // Problem: get all the pairs of num 1, 2, 3 and the letters between 'a', 'b', 'c'
  val allPais: List[String] = List(1, 2, 3)
      .flatMap(num => List('a', 'b', 'c')
      .map(letter => s"$num$letter"))
  // res == List(1a, 1b, 1c, 2a, 2b, 2c, 3a, 3b, 3c)

  /**
   * ? FOR COMPREHENSIONS
  More readable expression than map and flatmap
  Easier to write for complicated logics
  */
  val allParis2 =
    for
      num <- List(1, 2, 3)
      letter <- List('a', 'b', 'c')
      // optional conditions can be added like filter
    yield s"$num$letter"
  // res == List(1a, 1b, 1c, 2a, 2b, 2c, 3a, 3b, 3c)

  /**
   *! COLLECTIONS
   */

  /**
   * ? LISTS
   */
  val aList = List.range(1, 5)
  val firstElement = aList.head   // Removes the First element and returns it
  assert(firstElement == 1)
  val allExceptFirst = aList.tail           // Returns all but the First element in existing order
  assert(allExceptFirst == List(2, 3, 4))
  val prependedList = 0 :: aList            // OR -> 0 +: aList
  assert(prependedList == List.range(0, 5))
  val postPended = aList :+ 0           // aList :: 0 wont word as :: is not the member of List class
  assert(postPended == List(1, 2, 3, 4, 0))
  val preNpostPended = 0 +: aList :+ 5
  assert(preNpostPended == List.range(0, 6))
  assert(aList.take(3) == List(1, 2, 3))   // Returns first N elements AND all if N > length
  assert(aList.slice(1, 2) == List(2))    // until is not inclusive

  /**
   *? SEQUENCES
   ** Can directly get element from given index
   */
  val aSeq: Seq[Int] = Seq.range(1, 4)
  assert(aSeq(1) == 2)    // Gets element at Index 1 == 2

  /**
   *? VECTORS
   ** Faster access time than Sequences
   ** All the Container classes works very much like Java
   ** Shares lots of COMMON METHODS
   */
  val aVec: Vector[Int] = Vector(1, 2, 3, 4)
  assert(aVec.take(2) == Vector.range(1, 3))

  /**
   *? SETS
   */
  val aSet: Set[Int] = Set(1, 1, 2, 2, 3, 3)
  assert(aSet == Set(1, 2, 3))
  val anAddedSet = aSet + 4
  assert(anAddedSet == Set.range(1, 5))
  val anDeletedSet = aSet - 4
  assert(anDeletedSet == aSet)

  /**
   *? RANGES
   */
  val aRange: Range = 1 to 10
  val mulTwoEven = aRange.map(_ * 2).toList
  assert(mulTwoEven == List.range(2, 21, 2))

  /**
   *? TUPLES
   ** Works just like Python Tuple
   */

  /**
   *? MAPS
   */
  val aMap: Map[String, Int] = Map(
    ("Shakik", 4234234),
    "Ali" -> 2342343  // EQV
  )

}










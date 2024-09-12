package com.shakik

object Basics extends App {
  // VALUE ASSIGNMENTS
  val aVal: String = "Eqv. as const String aVal"
  var aVar: String = "Eqv. as String aVar"
  var anInt = 10    // Runtime type inference
  var aList: List[Int] = List.range(0, 10, 2)   // Works just like python
  aList = aList.takeRight(3)

  // CONTROL STATEMENTS
  var result: String =
    if false then "Skip"
    else if false then "Skip"
    else "The final result"
  result = if false then "False" else "True"  // Ternary eqv.

  // LOOPS
  // LOOPING IS HIGHLY DISCOURAGED
  // USE RECURSIONS AND ENJOY ITS FUNCTIONAL CAPABILITIES
  for i <- aList do print(i + ", ")
  println()

  for
    x <- aList
    if x%2 == 0   // Extended with conditional arg
  do
    println(s"x is Even")
  // A loop with similar characteristic as SQL CROSS JOIN between x and y
  // creates every possible combinations of x and y
  for
    x <- aList
    y <- 'a' to 'c'
    // OPTIONAL if x == 4 && y == 'c'
  do
    println(s"x = $x  |  y = $y")

  // Code block is a scoped area
  var count = 10
  val aCodeBlock: Unit =
    var count = 0
    // As many conditions as I need
    while (count < 3 && aList.nonEmpty) do  // Regular while loop
      count += 1
      println(s"count = $count")
  val anotherCodeBlock: Int =
    var num: Int = 0
    num += 10
    num += 20
    num     // It is what will be returned

  // FUNCTIONS
  private val anArray: Array[Int] = Array.range(10, 20)
  private def myReverseArray(arr: Array[Int]): Array[Int] =
    if arr.length <= 1 then arr
    else
      val head = arr.head
      val tailReversed = myReverseArray(arr.tail)
      tailReversed :+ head
  println(
    s"""${anArray.mkString("start ", " comma ", "  end")}
       |\nreversed to\n
       |${myReverseArray(anArray).mkString("[", ", ", "]")}""".stripMargin)

  // UNIT === VOID
  // ITS KIND OF A SIDE EFFECT
}

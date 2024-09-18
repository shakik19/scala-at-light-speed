package com.shakik

import scala.concurrent.Future
import scala.util.{Failure, Success}

object Advanced extends App {
  /**
   *! LAZY EVALUATION
   ** useful in infinite collections
   */
  lazy val aLazyVal = 4
  lazy val lazyValWithSideEffect =
    println("A lazy value block")
    10
  /**
   ** If only the above code is run nothing would be printed on the console
   ** Lets make the values evaluated
  */
  assert(aLazyVal + lazyValWithSideEffect == 14)


  /**
   *! IMPLICIT VALUES
   ** These are values that are automatically provided by the compiler in certain contexts

   *? How They Work
   **   Scope:
   **       When a method is called, the compiler searches for implicit values within the current scope,
   **       including the enclosing class, object, or package
   **   Type Matching:
   **       The compiler matches the type of the implicit value with the expected type of the implicit
   **       parameter or conversion
   **   Resolution:
   **        If multiple implicit values match the type, the compiler uses a complex
   **        resolution algorithm to determine the most suitable one
   */

  /**
   *? Implicit parameters:
   **    These are parameters that can be omitted from method calls if there's an implicit value of the
   **    correct type in scope
   */
  private def roundIt(implicit arg: Double): Int = arg.round.toInt
  implicit val aDouble: Double = 3423.234
  println(roundIt)    // <- compiler pushes arg in runtime

  /**
   *? Implicit conversions:
   **    These allow Scala to automatically convert values from one type to another if an
   **    implicit conversion function is available
   *? Implicit classes:
   **    These are classes that can be used for implicit conversions, providing additional
   **    methods to existing types
   */
  implicit class MyRichInt(n: Int):
    def isEven: Boolean = n % 2 == 0

  assert(!5.isEven)


  /**
   *! PSEUDO-COLLECTIONS

   *? Option()
   ** A generic type that represents an optional value.
   ** 1. It can either hold a value of type A (wrapped in Some(a)) or no value (represented by None).
   ** 2. Provides a safe way to handle potential null values or missing data.
   ** 3. Commonly used to avoid NullPointerExceptions and promote more robust code.

   *? Some()
   ** 1. A constructor of the Option type.
   ** 2. Creates an Option instance containing a non-null value of type A.
   ** 3. Ensures that the value is present and can be accessed safely.
   */
  val maybeName: Option[String] = Some("Shakik") // Option containing "Shakik"
  val maybeAge: Option[Int] = None // Option containing no value

  val name: String = maybeName.getOrElse("Unknown") // Accesses the value or uses a default
  val age: Int = maybeAge.getOrElse(0) // Accesses the value or uses a default

  // Null check
  val stringProcessing = maybeName match
    case Some(string) => s"Got a non-null value $string"
    case None => "maybeAge == None"

  /**
   *? Try
   ** try == a "collection" with either a value or an exception if the code threw one
   ** very similar to on Option. On captures nulls another errors
   */

//  val anException = throw new RuntimeException()
//  val stringProcessingV2 = anException match
//    case Success(validValue) => s"The value $validValue is valid"
//    case Failure(ex) => ex.printStackTrace()

}

















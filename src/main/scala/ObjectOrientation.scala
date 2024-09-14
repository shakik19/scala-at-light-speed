package com.shakik

import ObjectOrientation.Square.armCount
import java.io.FileNotFoundException
import java.io.IOException
import java.io.FileReader

/*
SINGLETON
Here ObjectOrientation is the only instance of ObjectOrientation type
*/
object ObjectOrientation extends App{
  // Class Declaration
  class SimpleClass(name: String):	// Here Name is constructor Arg and not a publicly accessible field
  	def simpleMethod(): Unit = println(s"A simple method of $name class")

  private val simpleClass: SimpleClass = new SimpleClass("Simple")
  simpleClass.simpleMethod()

  // INHERITANCE
  class ChildSimpleClass(name: String) extends SimpleClass(name):
    override def toString: String = "Overridden toString"

  val childSimpleClass = new ChildSimpleClass("Something")
  println(childSimpleClass)


  abstract class Animal:
    def makeSound(): Unit

  //Constructor args are not FIELDS by DEFAULT and class scoped
  abstract class DogBreed(val name: String) extends Animal:
    override def makeSound(): Unit = println(s"A $name is Barking")
    // Default method
    def makeSound(n: Int): Unit =
      if n == 0 then return
      makeSound(n - 1)
      println(s"${n} $name is Barking")
    // Method Signature
    def sayMyName(): Unit

  //	ANONYMOUS INNER CLASS
  val dogBreed: DogBreed = new DogBreed("German Shepherd"):
    override def sayMyName(): Unit = println(s"I'm of $name")

  dogBreed.sayMyName()
  dogBreed.makeSound()
  //	DYNAMIC METHOD DISPATCH
  dogBreed.makeSound(3)


  // TRAIT == INTERFACE
  trait Carnivore:
  	def eat(): Unit
  	// trait supports default methods like java interface
  	def someMethod(): Unit = println("someMethod of Carnivore trait")


  // POLYMORPHISM
  // Scala Supports SINGLE CLASS MULTI-TRAIT INHERITANCE AKA MIXING
  class Dog(breedName: String, name: String) extends DogBreed(breedName) with Carnivore:
    override def sayMyName(): Unit = println(s"My name is $name and I'm a ${breedName}")
    override def makeSound(): Unit = println(s"$name is Barking")
    override def eat(): Unit = println(s"$name is eating")


  // SUB-TYPE POLYMORPHISM
  val dog: Dog = new Dog("Husky", "John Boy")
  dog.sayMyName()
  // Method of ONLY ONE ARG can also be declared in INFIX notation
  // like - `OBJ IF ANY` `METHOD NAME` `ARGS`
  dog makeSound 3
  dog.makeSound()
  dog.someMethod()
  dog.eat()

  object Demo:
    // This apply() method comes very handy in Functional Programming
    // It allows an Object or Class to be invoked like a function
    def apply(breed: String, name: String): Dog = new Dog(breed, name)

  var dog2 = Demo("Rot oiler", "Mike")
  dog2 = Demo.apply("Labrador", "Modi") // Equivalent to Demo(...)
  dog2.sayMyName()

  //  COMPANIONS
  class Square():
    def getArmCount: Int = armCount
    def area(armLength: Double): Double = armLength * armLength
  object Square:
    private val armCount = 4
    def squareAreaFormula(): Unit = println("Arm^2")
    /*
    Here class Square and singleton object Square are COMPANIONS
    It's particularly useful when we have a method that is not dependent on the
    Square class and can be used without instantiating using the object Square
    Recall Static methods -> Everything inside Object companions are static
    */

  /*
  CASE CLASSES -> lightweight data structure with some boilerplate
  auto generates the following,
    - sensible equals and hashcode
    - quick serialization (Beneficial for wire transfer in distributed systems)
    - default companion with apply -> Can be initialized without the keyword *new
    - pattern matching
  */


  //  EXCEPTIONS
  var text: FileReader = null
  try
    text = new FileReader("filename")
  catch
    case fnf: FileNotFoundException => fnf.printStackTrace()
    case ioe: IOException => ioe.printStackTrace()
  finally
    println("Came to the 'finally' clause.")


  //   GENERICS
  // Just like JAVA! no exception
  abstract class MyList[T]:
    def head: T
    def tail: MyList[T]


  /*
  IMPORTANT POINTS
  #1: In Scala we usually work with IMMUTABLE values/objects
  #2: Any modification to an object should return a new object
  #3: Very Close to ideal Object Oriented

  BENEFITS:
  #1: Works miracles in multithreaded/distributed env (Speed ups the development)
  #2: helps making sense (Reasoning about)
  #3:
  */

}


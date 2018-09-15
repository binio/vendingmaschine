package com.binio.tutorial

//name will not be accesible
class Dragon(name: String)

//we can omit name in constructor then Unknown will be used
class Dog(val name:String = "Unknown")

//named parameters
class Coordinate (val lattitude:Double, val longitude:Double)

//apply method
class Cat(val name:String)
object Cat {
  def apply(name: String):Cat =
    new Cat(name)
  def apply(name: String, age: String):Cat =
    new Cat(name + "-" + age)
}

//companion object

object Dictionary {

  val sentenceA = "Hi there!"
  def sentenceB(n: String) = s"Welcome $n!"
  val sentenceC = "What's up bro"
}


abstract class Robot(val name: String) {
  def welcome(name: String):String
}

object Robot {
  def mostTalkative(robot1: Robot, robot2: Robot):Robot = {
    val r1size = robot1.welcome("Tom").length
    val r2size = robot2.welcome("Bob").length
    if(r1size > r2size) robot1 else robot2
  }
}

//traits
trait Animal {
  val sleep = "Zzzz"  //default implemetation provided
  def eat(food: String): String
  def move(x:Int, y:Int)
}

class Monkey extends Animal {

  override def eat(food: String): String = "Monkey eats " + food

  override def move(x: Int, y: Int): Unit = println(s"Monkey moves to $x and $y")
}

object Main extends  App {

  //traits
  val monkey = new Monkey
  println(monkey.eat("Banana"))
  monkey.move(12,10)


  //objects
  val a = new Dragon("Thomas")
  val b = new Dragon("Rob")
  val c = new Dog("Kuba")    //with accesible name
  val d = new Dog("Reksio")  //with accesible name
  val e = new Dog()                  //with Unknown name
  val cord = new Coordinate(lattitude = 12.1, longitude = 10.9)

  //apply
  val c1 = new Cat("micus")
  val c2 = Cat("mruczek")
  val c3 = Cat("mruczek", "21")

  println(c1.name)
  println(c2.name)
  println(c3.name)

  //companion object
  val tom = new Robot("Tom 1") { def welcome(n: String) = Dictionary.sentenceA } // we compose new object and its welcome function out of dictionary
  val bob = new Robot("Bob 1") { def welcome(n: String) = Dictionary.sentenceB(n) }

  println(Robot.mostTalkative(tom, bob).name)
  println(tom.welcome("test"))
  println(bob.welcome("test"))


  println(a)
  println(b)
  println(c.name)
  println(d.name)
  println(e.name)
  println(cord.lattitude)
  println(cord.longitude)



}

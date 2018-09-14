package com.binio.tutorial

//name will not be accesible
class Dragon(name: String)

//we can omit name in constructor then Unknown will be used
class Dog(val name:String = "Unknown")

//named parameters
class Coordinate (val lattitude:Double, val longitude:Double)

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

object Main extends  App {

  val a = new Dragon("Thomas")
  val b = new Dragon("Rob")
  val c = new Dog("Kuba")    //with accesible name
  val d = new Dog("Reksio")  //with accesible name
  val e = new Dog()                  //with Unknown name
  val cord = new Coordinate(lattitude = 12.1, longitude = 10.9)

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

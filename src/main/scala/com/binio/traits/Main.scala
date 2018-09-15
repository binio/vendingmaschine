package com.binio.traits

trait Cute {
  def fun():String = "I am cute city"
}

class House(val rooms:Int)
class City(val name:String) extends Cute
trait BigTrait extends House {
  def fun():String = "I am big house"
}

object Main extends App{

  //1. Class can extend trait
  val city = new City("Wejherowo")
  println(city.name)
  println(city.fun())

  //2. TRait can extend class
  val house = new House(5)
  println(house.rooms + " rooms")

  //3. Class extends Big Trait
  //class Mistake(override val rooms:Int) extends BigTrait
  //val mistake = new Mistake(7)
  //println(mistake.rooms)
  //println(mistake.fun())
  //does not compile Unspecified value parameter rooms.
  //[error]   class Mistake(override val rooms:Int) extends Big

}

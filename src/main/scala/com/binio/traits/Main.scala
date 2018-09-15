package com.binio.traits

trait Cute {
  def fun():String = "I am cute city"
}

class City(val name:String) extends Cute

object Main extends App{

  //1. Class can extend trait
  val city = new City("Wejherowo")
  println(city.name)
  println(city.fun())

}

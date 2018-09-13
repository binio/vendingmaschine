package com.binio.tutorial

class Dragon(name: String)
class Dog(val name:String)

object Main extends  App {

  val a = new Dragon("Thomas")
  val b = new Dragon("Rob")
  val c = new Dog("Kuba")
  val d = new Dog("Reksio")


  println(a)
  println(b)
  println(c.name)
  println(d.name)

}

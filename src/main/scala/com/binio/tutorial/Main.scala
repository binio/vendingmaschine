package com.binio.tutorial

//name will not be accesible
class Dragon(name: String)

//we can omit name in constructor then Unknown will be used
class Dog(val name:String = "Unknown")

object Main extends  App {

  val a = new Dragon("Thomas")
  val b = new Dragon("Rob")
  val c = new Dog("Kuba")    //with accesible name
  val d = new Dog("Reksio")  //with accesible name
  val e = new Dog()                  //with Unknown name


  println(a)
  println(b)
  println(c.name)
  println(d.name)
  println(e.name)

}

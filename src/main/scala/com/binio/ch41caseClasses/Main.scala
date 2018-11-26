package com.binio.ch41caseClasses

object Main extends App {

  //case classes come with a lot of methods generated
  //to define one below
  case class Person(fname:String, lname:String)

  //create instance
  val thomas = Person("Tomasz", "Biniecki")
  println(thomas.fname)
  println(thomas.lname)

  //we already have generated getters apply so dont need to use "new" to create instance
  var ania = Person("Anna", "Biniecka")
  println(ania.fname)
  println(ania.lname)

  //try to mutate will throw an error
  //ania.fname = "Lalala"


  //unapply method is used for pattern matching
  thomas match {
    case Person(fname , lname) => println("Matched Person")
  }

  val personList = List(thomas,ania)

  for {
    x <- personList
  } {
    val person = x match {
      case Person("Tomasz",_)  => println("Matched TOMASZ")
      case Person(_,_) if(x.fname == "Anna") => println("Matched Anna")
    }
  }

  //copy method used for mutation
  val thomas2 = thomas.copy("Binio")
  println(thomas2.fname)
  println(thomas2.lname)

  //default method toString
  println(thomas2)

  //default mathod equals

  println(thomas2 == thomas)


}

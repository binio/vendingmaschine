package com.binio.ch43forComprehension

import com.binio.ch41caseClasses.Main.Person

object Main extends App{

  val people = List(
    Person("Tomasz","Moris"),
    Person("Tadek","Nowak"),
    Person("Anna","Buda"),
    Person("Tomasz","Binio")
  )

  for {
    p <- people
    lname = p.lname
    if(lname!= "Binio")
  } yield println(lname)

  for {
    p <- people
    person = p
    if(person.lname == "Buda")
  } yield println(person.fname + " " + person.lname)
}

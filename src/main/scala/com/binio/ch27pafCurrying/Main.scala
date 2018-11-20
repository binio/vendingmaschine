package com.binio.ch27pafCurrying

object Main extends App{

  //currying

  def add(a:Int)(b:Int):Int =  a + b
  println(add(10)(20))

  def add15 = add(15)(_)
  println(add15(2))


}

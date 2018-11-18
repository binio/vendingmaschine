package com.binio.ch26multipleFunctionParams

object Main extends App {

  def sumMtl(a:Int)(b:Int)(c:Int):Int = a +b + c

  println(sumMtl(1)(2)(3))

  def whilst(condition: => Boolean)(code: => Unit) = {
    while(condition) {
      code
    }
  }

  var i = 0
  whilst(i<7) {
    println("executing wilst: "+ i)
    i+=1
  }

  def printSomething(k:Int):Unit = println("printing from other code block: "+ k)

  whilst(i<10) {
    printSomething(i);
    i += 1
  }

  /*
  implement ifBothTrue(age>18)(numAccidents == 0){
    println("discount")
  }
   */

  def ifBothTrue(age: => Boolean)(accidents: => Boolean)(discounts: => Unit): Unit = {
    if(age && accidents) discounts
  }

  val age:Int = 45
  val accidents:Int = 0

  ifBothTrue(age > 30)(accidents == 0) {
    println("discount of 20%")
  }

  /*
  using implicit values
   */

  implicit val sth: Boolean = true
  implicit val sth2: Int = 5

  def printIfTrue(a: Int)(implicit b: Boolean, c:Int) = if(b) println(a + " " + c)  // all params in second group are implicit
  printIfTrue(111)(true,2)
  printIfTrue(111) //this will work only if there is implicit value defined only one though, if there are more it will trow ambigous implicit value

  /*
  using  default values in function
   */

  def f2(a:Int = 1)(b:Int = 2):Int = a+b
  println(f2(10)(90))
  println(f2()(90))
  println(f2(10)())
  println(f2()()) //to use default values supply empty ()

  /*
  using variables from
   */
}

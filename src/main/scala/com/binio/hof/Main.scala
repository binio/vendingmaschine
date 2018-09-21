package com.binio.hof

object Main extends App {

  private def abs(n:Int):Int = {
    if(n < 0) n
    else n
  }

  private def formatAbs(x:Int):String = {
    val msg = "The absolute value of %d id %d"
    msg.format(x, abs(x))
  }

  private def formatFactorial(x: Int):String ={
    val msg = "The factorial value of %d id %d"
    msg.format(x, abs(x))
  }

  private def formatResult(name:String, n:Int, f: Int => Int):String = {
    val msg = "The %s of %d id %d"
    msg.format(name, n, f(n))
  }

  def factorial(n: Int):Int = {
    def loop(n:Int, acc:Int): Int ={
      if(n <=0 ) acc
      else loop(n - 1, n*acc)
    }
    loop(n, 1)
  }



  def fib(n:Int):Int = {
    def loop(n:Int): Int =
      if(n < 2) n
      else fib(n-1) + fib(n-2)

    loop(n)
  }


  println(fib(0))
  println(fib(1))
  println(fib(2))
  println(fib(3))
  println(fib(4))

  println(formatAbs(abs(7)))
  println(formatFactorial(factorial(10)))

  //converting to HOF non polymorfic version
  println(formatResult("factorial", 10, factorial))
  println(formatResult("absolute value", 10, abs))



}

package com.binio.hof

object Main extends App {

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
}

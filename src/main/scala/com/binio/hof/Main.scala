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

  def findFirst(ss: Array[String], key: String): Int = {
    def loop(n: Int): Int =
      if(n >= ss.length) -1
      else if (ss(n) == key) n
      else loop(n + 1)

    loop(0)
  }

  def findFirstx[A](ss: Array[A], f: A => Boolean): Int = {
    def loop(n: Int): Int =
      if(n >= ss.length) -1
      else if (f(ss(n))) n
      else loop(n + 1)

    loop(0)
  }

  //this check if sorted from low to high only, strange
  def isSorted[A](as: Array[A], ordering: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(n: Int): Boolean =
      if (n >= as.length - 1) true
      else if (!ordering(as(n), as(n + 1))) false
      else go(n + 1)

    go(0)
  }


  //check if elements are the same
  def checkTheSame[A](as:Array[A], same:(A,A) => Boolean): Boolean = {
    def go(n:Int): Boolean =
      if(n>= as.length -1)  true
      else if(!same(as(n), as(n+1))) false
      else go(n+1)

    go(0)
  }

  //partial1, currying example
  def partial1[A,B,C](a:A, f: (A,B) => C): B => C = {
    (b:B) => f(a,b)
  }
  //I do not understand why is like this
  def curry[A,B,C](f: (A,B) => C): A => (B => C) = {
    a => b => f(a,b)
  }

  //non curried sum function
  def sumNonCurried(a: Int, b: Int):Int = a + b

  //curried sum function
  def sumCurried(a: Int):Int => Int = (b:Int) => a + b

  def uncurry[A,B,C](f:A => B => C):(A,B) => C = {
    (a,b) => f(a)(b)
  }

  //sum from odersky course
  def sumOdr(f:Int => Int)(a: Int, b: Int): Int = {
    if(a > b) 0 else f(a) + sumOdr(f)(a + 1, b)
  }


  //multiplication
  def mltx(x: Int, y: Int): Int = x * y

  def mltxCurried(x:Int): Int => Int = (y:Int) => x * y

  def mltxCurriedG[A](x: A, f:(A, A) => A): A => Any = (y: A) => f(x,y)


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

  //find non polymorfic
  println(findFirst(Array("kkk", "hello", "ooops"), "hello"))
  println(findFirstx(Array("kkk", "hello", "ooops", "tomasz"), (x:String) => x =="hello"))


  //usage of isSorted function
  println("isSorted: [1, 3, 5, 7, 8] " + isSorted(Array(1, 3, 5, 7, 8), (x: Int, y: Int) => y > x))
  println("isSorted: [7, 5, 3, 1]" + isSorted(Array(7, 5, 3, 1), (x: Int, y: Int) => y < x))
  println(isSorted(Array("Scala", "Exercises"), (x: String, y: String) => y.length > x.length))

  //check if elements are the same
  //(x: Int, y: Int) => x == y) shows that we check if x==y in array
  //so as for isSorted it would be better to negate expression else if(!same(as(n), as(n+1))) false
  println("The same:" + checkTheSame(Array(7, 5, 3, 1), (x: Int, y: Int) => x == y))
  println("The same:" + checkTheSame(Array(1, 1, 1, 1), (x: Int, y: Int) => x == y))
  println("The same:" + isSorted(Array(1, 1, 1, 1), (x: Int, y: Int) => x == y)) //name could be more generic

  println("sumNonCurried: " + sumNonCurried(23, 7))
  println("sumCurried: " + sumCurried(23)(7))
  println("sumCurried: " + sumCurried(sumCurried(23)(7))(10))

  println("mltx: " + mltx(10,7))
  println("mltxCurried: " + mltxCurried(10)(7))
  println("mltxCurriedG: " + mltxCurriedG(10, x * y )(7))


}

package com.binio.fpsimplified

import com.binio.fpsimplified.Main.sumTailRec

import scala.annotation.tailrec

object Main extends App {

  def stackTrace():Unit = {
    val stackTraceArray = Thread.currentThread().getStackTrace
    stackTraceArray.foreach(println)
  }
  /*
    tail recursive function as a last opperation calls itself
   */
  @tailrec
  def sumTailRec(l:List[Int], acc:Int = 0): Int = l match {
    case Nil => {
      stackTrace()
      acc
    }
    case _ => sumTailRec(l.tail, acc + l.head)
  }

  /*
    this is not tail recursive function as we have last opperation
    x + sumRec(xs)
   */
  //@tailrec
  def sumRec(l:List[Int]): Int = l match {
    case Nil => {
      stackTrace()
      0
    }
    case x::xs => x + sumRec(xs)
  }

  def sum(l:List[Int]):Int = sumTailRec(l)

  //or we can do this

  def sumV2(l:List[Int]):Int = {
    @tailrec
    def sumTR(l:List[Int], acc:Int = 0): Int = l match {
      case Nil => {
        stackTrace()
        acc
      }
      case _ => sumTR(l.tail, acc + l.head)
    }
    sumTR(l)
  }

  println(sumTailRec(List.range(1,10000)));
  println(sum(List.range(1,10000)));
  println(sumV2(List.range(1,10000)));

  println(sumRec(List.range(1,10)));

}

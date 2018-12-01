package com.binio.ch45createClassToForComprehension

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

case class Sequence[A](initialElements:A*) {
  private val elems = scala.collection.mutable.ArrayBuffer[A]()
  elems  ++= initialElements

//we reuse foreach whi is from ArrayBuffer
//  below I tried to use my own but does not work as signature problem
  def foreachx(block: A => Unit): Unit = {
    elems.foreach(block)
  }


  def map[B](f: A => B):Sequence[B] = {
    val abMap: ArrayBuffer[B] = elems.map(f)
    Sequence(abMap: _*)
  }

//  def foreach(elems:ArrayBuffer[A]):A =  {
//    elems.tail match {
//      case _ if(elems.tail == Nil) => {
//        println("second case: " + elems.head)
//        elems.head
//      }
//      case _ => {
//        println("first case: " + elems.head)
//        foreach(elems.tail)
//      }
//    }
//  }

    @tailrec
    final def foreachAccumulator(f: (A) => Unit, elements:ArrayBuffer[A]): Unit = {
      elements.size match {
        case 0 => Unit
        case _ => {
          f(elements.head)
          foreachAccumulator(f, elements.tail)
        }
      }
    }

    def foreach(f: A => Unit): Unit =  {
      foreachAccumulator(f, elems)
    }
}

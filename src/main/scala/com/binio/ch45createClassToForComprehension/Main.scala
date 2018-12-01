package com.binio.ch45createClassToForComprehension

import scala.collection.mutable.ArrayBuffer

object Main extends App{

  val ints = Sequence(1,2,34,7)
  for(i <- ints) println(i)

  println(ints)

  val newSequence =   for {
    i <- ints
  } yield i * 2

  println(newSequence)


  ints.foreach(println)

}

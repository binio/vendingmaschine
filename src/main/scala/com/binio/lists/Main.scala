package com.binio.lists

object Main extends App {

  def exists[A](l:List[A], i:A):Boolean = l match {
    case Nil => false
    case _ if(l.head == i) => true
    case _ if(l.head != i)=> exists(l.tail, i)

  }

  def existsTimes[A](l:List[A], i:A, t:Int = 0):Int = {
    l match {
      case Nil => t
      case _ if (l.head == i) => existsTimes(l.tail, i, 1 + t)
      case _ if (l.head != i) => existsTimes(l.tail, i, t)
    }
  }

  def reverse(l:List[Int], p:List[Int]):List[Int] = {
    l match {
      case Nil => p
      case _ if(existsTimes(l, l.head, 0) > 0) => reverse(l.tail, l.head :: p)
    }
  }

  def reverseOne(l:List[Int], k:List[Int] = List()):List[Int] = {
    l match  {
      case Nil => k
      case _ => reverseOne(l.tail, l.head::k)
    }
  }

  def distinct[A](l:List[A], k:List[A]):List[A] = {
    l match {
      case Nil => k
      case _  if(exists(k, l.head) == false) => distinct(l.tail, l.head::k)
      case _  if(exists(k, l.head) == true) => distinct(l.tail, k)
    }
  }
}
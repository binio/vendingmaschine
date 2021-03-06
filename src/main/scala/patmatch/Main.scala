package patmatch

import patmatch.Main.List.sum

object Main extends App{

  sealed trait List[+A]
  case object Nil extends List[Nothing]
  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {
    def sum(ints: List[Int]): Int = ints match {
      case Nil => 0
      case Cons(x, xs) => x + sum(xs)
    }

    def product(ds: List[Double]): Double = ds match {
      case Nil => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(x,xs) => x * product(xs)
    }

    def apply[A](as: A*): List[A] = // Variadic function syntax
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))

    def tail(list: List[Int]):List[Int] = list match {
      case Nil => sys.error("No elements found")
      case Cons(_,at) => at
    }

    def drop[A](l:List[A], n:Int):List[A] =   {
      if (n == 0) l
      else l match {
        case Nil => Nil
        case Cons(_,t) => drop(t, n-1)
      }
    }

    def dropWhile[A](l:List[A], f:A => Boolean):List[A] =  l match {
      case Cons(h, t) if(f(h)) => dropWhile(t,f)
      case _ => l

    }

    def dropWhileB[A](as:List[A])(f: A => Boolean) : List[A] = as match {
      case Cons(h,t) if (f(h)) => dropWhileB(t)(f)
      case _ => as
    }

    def init[A](l:List[A]):List[A] = l match {
      case Nil => sys.error("empty collection found")
      case Cons(_,Nil) => Nil
      case Cons(h,t) => Cons(h,init(t))
    }


    def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f)) }

    def length(l: List[A]):Int = {
      foldRight(l,0)(_,acc) => acc + 1
    }

  }

  println(List.length(List(1,2,3,4,5,6,77)))

  val x = List(1, 2, 3, 4, 5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t) => h + sum(t)
    case _ => 101
  }

  println(x)

  List(1,2,3) match {
    case _ => 42
  }

  List.tail(List(1, 2, 3, 4, 5))

  println(List.init(List(1, 2, 3, 4, 5)))

  List(1,2,3) match {
    case Cons(h,_) => h
  }

  List(1,2,3) match {
    case Cons(_,t) => t
  }

  List(1,2,3) match {
    case Nil => 42
    case Cons(1,_) => 101
  }




}

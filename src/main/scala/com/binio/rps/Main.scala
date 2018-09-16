package com.binio.rps

object Main extends App{

  val game = Game(playerA = "Sheldon", playerB = "Leonard")
  println(game.round(Paper, Scizors))
  println(game.round(Paper, Paper))
  println(game.round(Rock, Scizors))
}

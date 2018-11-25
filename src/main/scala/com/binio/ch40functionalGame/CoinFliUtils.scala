package com.binio.ch40functionalGame

import scala.io.StdIn
import scala.util.Random

object CoinFliUtils {

  def showPrompt():Unit = println("\n(h)eads, (t)ails, or (q)uit")

  def getUserInput() = StdIn.readLine().trim.toUpperCase()

  def printableFlipResult(flip: String) = flip match {
    case "H" => "Heads"
    case "T" => "Tail"
  }

  def printGameState(gameState: GameState): Unit = {
    println(s"#Flips: ${gameState.numFlips}, #Correct: ${gameState.numCorrect}")
  }

  def printGameState(printableResult: String, gameState:GameState):Unit = {
    println(s"Flip was $printableResult. ")
    printGameState(gameState)
  }

  def printGameOver():Unit = {
    println("===== GAME OVER =====")
  }

  def tossCoin(r: Random): String = {
    val i = r.nextInt(2)
    i match {
      case 0 => "H"
      case 1 => "T"
    }
  }

}

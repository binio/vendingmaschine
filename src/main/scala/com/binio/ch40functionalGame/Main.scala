package com.binio.ch40functionalGame

import scala.util.Random
import CoinFliUtils._

import scala.annotation.tailrec

case class GameState(numFlips:Int, numCorrect:Int)

object Main extends App {
  val r = Random
  val s = GameState(0, 0)
  mainLoop(s,r)

  @tailrec
  def mainLoop(gameState:GameState, random: Random): Unit = {
    //a) prompt user for input
    showPrompt()

    //b) get user input
    val userInput = getUserInput()


    userInput match {
      case "Q" => {
        printGameOver()
        printGameState(gameState)
      }

      case "T" | "H" => {
        //c) flip coin
        val coinResult = tossCoin(r)
        val newNumFlips = gameState.numFlips + 1

        //d) compare results to user input
        val newGameState = gameState.copy(numFlips = newNumFlips)

        if(userInput == coinResult) {
          val newNumCorrect = gameState.numCorrect + 1
          val newGameState = gameState.copy(numFlips = newNumFlips, numCorrect = newNumCorrect)

          //e) write the output
          printGameState(printableFlipResult(coinResult), newGameState)

          //f) loop again
          mainLoop(newGameState, random)
        } else {
          printGameState(printableFlipResult(coinResult), newGameState)
          mainLoop(newGameState, random)

        }

      }
    }

  }

}

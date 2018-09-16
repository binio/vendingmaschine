package com.binio.rps

case class Game(playerA:String, playerB:String) {
  def round(symbolA:Symbol, symbolB:Symbol): String = {
    if(symbolA.wins(symbolB)) s"Player PlayerA wins"
    else if (symbolB.wins(symbolA)) s"Player PlayerB wins"
    else s"It is a tie!"
  }


}

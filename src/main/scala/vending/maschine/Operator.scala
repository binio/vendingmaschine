package vending.maschine

class Operator(maschine: VendingMaschine) {

  def collectMoney(): String = {
    maschine.totalMoney = 0
    "I have collected all the money"
  }

  def refillProduct(chocolate: Int, granola: Int) = {
    maschine.chocolateBar = chocolate
    maschine.granolaBar = granola
  }
}

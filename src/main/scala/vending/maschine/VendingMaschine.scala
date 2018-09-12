package vending.maschine

class VendingMaschine {

  private [vending] var totalMoney: Double = 0
  private [vending] var chocolateBar = 0
  private [vending] var granolaBar = 0
  private final val GRANOLA = "granola"
  //private var totalMoney: Double = 0

  def buy(product: String, money: Double): String = {
    if(!isProductAvailable(product))
      "Sorry product is not available"
    else if (!isMoneyEnough(product, money))
      "Please insert more money"
    else
      completeRequest(product, money)


  }
  def isProductAvailable(product: String): Boolean = {
    val productQuantity = product.toLowerCase match {
      case "chocolate" => chocolateBar
      case "granola" => granolaBar
      case _ => -1
    }
    productQuantity > 0
  }

  def isMoneyEnough(product: String, money: Double): Boolean = {
    product.toLowerCase match {
      case "chocolate" => money >= 1.5
      case "granola" => money >= 1.0
    }
  }

  def collectMoney(money: Double) = {
    totalMoney += money
  }

  private def releaseProduct(product: String) = {
    product match {
      case "chocolate" => chocolateBar - 1
      case "granola" => granolaBar - 1
    }
  }

  def completeRequest(product: String, money: Double): String = {
    collectMoney(money)
    releaseProduct(product)
    "there you go"
  }
}

package vending.maschine

object Main extends App {

  val machine = new VendingMaschine
  val operator = new Operator(machine)
  operator.refillProduct(2, 2)
  println(machine.buy("granola", 2.0))
  println(machine.buy("granola", 2.0))
  println(machine.buy("granola", 2.0))
  println(machine.buy("granola", 2.0))

}
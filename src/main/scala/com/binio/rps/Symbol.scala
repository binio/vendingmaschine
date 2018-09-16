package com.binio.rps

trait Symbol {
  protected def beats:List[Symbol]
  def wins(other:Symbol):Boolean = beats.contains(other)

}

case object Rock extends Symbol {
  protected val beats = List(Lizard, Scizors)
}

case object Paper extends Symbol {
  protected val beats = List(Rock, Spock)
}

case object Scizors extends Symbol {
  protected val beats = List(Paper, Lizard)
}

case object Lizard extends Symbol {
  protected val beats = List(Spock, Paper)
}

case object Spock extends Symbol {
  protected val beats = List(Scizors, Rock)
}

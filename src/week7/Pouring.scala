package week7

class Pouring(capacity: Vector[Int]) {
  // States
  //type State = Vector[Int]
  val initialState = capacity map (x => 0)

  // Moves
  trait Move {
    def change(state: Vector[Int])
  }

  case class Empty(glass: Int) extends Move {
    def change(state: Vector[Int]) = state updated (glass, 0)
  }
  case class Fill(glass: Int) extends Move {
    def change(state: Vector[Int]) = state updated (glass, capacity(glass))
  }
  case class Pour(from: Int, to: Int) extends Move {
    def change(state: Vector[Int]) = {
      val amount = state(from) min (capacity(to) - state(to))
      state updated (from, state(from) - amount) updated (to, state(to) + amount)
    }
  }

  val glasses = 0 until capacity.length

  val moves =
    (for (g <- glasses) yield Empty(g)) ++
      (for (g <- glasses) yield Fill(g)) ++
      (for (from <- glasses; to <- glasses if from != to) yield Pour(from, to))

  // Paths - Last moves comes first
  class Path(history: List[Move]) {
    /*
    def endState: Vector[Int] = (history foldRight initialState) (_ change _)
    def endState: State = trackState(history)
    private def trackState(xs: List[Move]): State = xs match {
      case Nil => initialState
      // foldRight operation as last moves comes first
      case move :: xs1 => move change trackState(xs1)
    }
    */
  }
}
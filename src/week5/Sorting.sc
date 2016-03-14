object Sorting {
  println("Welcome to the Scala worksheet")

  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
        case Nil => ys

        case x :: xs1 =>
          ys match {
            case Nil => xs

            case y :: ys1 =>
              if (x < y) x :: merge(xs1, ys)
              else y :: merge(xs, ys1)
          }
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }

  def msort1(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge1(xs: List[Int], ys: List[Int]): List[Int] =
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (x < y) x :: merge1(xs1, ys)
            else y :: merge1(xs, ys1)
        }

      val (fst, snd) = xs splitAt n
      merge1(msort(fst), msort(snd))
    }
  }

  msort(List(3, 6, 1, 7, 12, 0, 5))
  msort1(List(3, 6, 1, 7, 12, 0, 5))
}
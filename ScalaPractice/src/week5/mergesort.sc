package week5

object mergesort {
	def msort(xs: List[Int]): List[Int] = {
		val n = xs.length / 2
		if (n == 0)	xs
		else {
			def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
				case (Nil, ys) => ys
				case (xs, Nil) => xs
				case (x :: xs1, y :: ys1) =>
					if (x < y)	x :: merge(xs1, ys)
					else y :: merge(xs, ys1)
			}
			
			val (firstList, secondList) = xs splitAt n
			merge(msort(firstList), msort(secondList))
		}
	}                                         //> msort: (xs: List[Int])List[Int]

	val nums = List(2, 8, -3, 0, 7, 1)        //> nums  : List[Int] = List(2, 8, -3, 0, 7, 1)
	
	msort(nums)                               //> res0: List[Int] = List(-3, 0, 1, 2, 7, 8)
}
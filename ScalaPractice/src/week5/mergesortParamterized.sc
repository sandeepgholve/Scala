package week5

object mergesort1 {
	def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
		val n = xs.length / 2
		if (n == 0)	xs
		else {
			def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
				case (Nil, ys) => ys
				case (xs, Nil) => xs
				case (x :: xs1, y :: ys1) =>
					if (ord.lt(x, y))	x :: merge(xs1, ys)
					else y :: merge(xs, ys1)
			}
			
			val (firstList, secondList) = xs splitAt n
			merge(msort(firstList), msort(secondList))
		}
	}                                         //> msort: [T](xs: List[T])(implicit ord: Ordering[T])List[T]

	val nums1 = List(2, 8, -3, 0, 7, 1)       //> nums1  : List[Int] = List(2, 8, -3, 0, 7, 1)
	val fruits = List("Apple", "Kieve", "Banana", "Pears")
                                                  //> fruits  : List[String] = List(Apple, Kieve, Banana, Pears)
	
	// msort(nums1)((x, y) => x < y)
	msort(nums1)                              //> res0: List[Int] = List(-3, 0, 1, 2, 7, 8)
	msort(fruits)                             //> res1: List[String] = List(Apple, Banana, Kieve, Pears)
}
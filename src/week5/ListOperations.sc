object ListOperations {
  val intList = List(1,2,3,4,5)
  val emptyList: List[Int] = Nil

  intList.reduceLeft(_ * _)
  intList.reduceLeft(_ + _)
  intList.foldLeft(1)(_ * _)
  intList.foldLeft(0)(_ + _)
  intList.reduceRight(_ * _)
  intList.reduceRight(_ + _)

  emptyList.reduceLeft(_ * _)
  emptyList.foldLeft(1)(_ * _)
}
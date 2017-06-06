package week5

object ListOperations {
	val intList = List(1,2,3,4,5)             //> intList  : List[Int] = List(1, 2, 3, 4, 5)
	val emptyList: List[Int] = Nil            //> emptyList  : List[Int] = List()

	intList.reduceLeft(_ * _)                 //> res0: Int = 120
	intList.reduceLeft(_ + _)                 //> res1: Int = 15
	intList.foldLeft(1)(_ * _)                //> res2: Int = 120
	intList.foldLeft(0)(_ + _)                //> res3: Int = 15
	intList.reduceRight(_ * _)                //> res4: Int = 120
	intList.reduceRight(_ + _)                //> res5: Int = 15
	
	emptyList.reduceLeft(_ * _)               //> java.lang.UnsupportedOperationException: empty.reduceLeft
                                                  //| 	at scala.collection.LinearSeqOptimized$class.reduceLeft(LinearSeqOptimiz
                                                  //| ed.scala:137)
                                                  //| 	at scala.collection.immutable.List.reduceLeft(List.scala:84)
                                                  //| 	at week5.ListOperations$$anonfun$main$1.apply$mcV$sp(week5.ListOperation
                                                  //| s.scala:14)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week5.ListOperations$.main(week5.ListOperations.scala:3)
                                                  //| 	at week5.ListOperations.main(week5.ListOperations.scala)
	emptyList.foldLeft(1)(_ * _)
}
val matrix = List(List(1,2,3), List(4,5,6), List(7,8,9))

val transpose = matrix.transpose

matrix.flatten.sum




trait Fruit /*extends Product with Serializable*/
case class Apple(name: String) extends Fruit
case class Orange(name: String) extends Fruit

val fruits:List[Fruit] = List(Apple("Fiji"), Orange("Jaffa"), Apple("Cox's"))

// collect = like a map + filter combined
fruits.collect {
  case a: Apple => a
}

//but List[Fruit]
val appleFruit:List[Fruit] = fruits.filter {
  case _: Apple=> true
  case _: Orange => false
}
val apples = appleFruit.map(_.asInstanceOf[Apple])


val words = List("four", "four", "char", "word")

words.groupBy(_.head)
words.groupBy(_.head).mapValues(_.size)


val nums = List.range(0, 10)
nums.grouped(3).take(5).toList
nums.sliding(3,2).take(5).toList
//val totalCombos = nums.combinations(3).size
// C (n,r) = n! / r! (n-r)! ; n = 10, r = 3
nums.combinations(3).take(10).toList
nums.permutations.take(3).toList
// val permtotal = nums.permutations.size = n!

val l = List(1,2,3)
val p = l.permutations.toList //n! = 6
val numsPlusOne: List[Int] = nums.map(_ + 1)

nums.corresponds(numsPlusOne)((a, b) => a + 1 == b)


val chars = List.range('a', 'h')

val idx = chars.indices

chars.zip(idx)

/**
 * one useful advantage would be to parallelize work
 * and combine and sort based on index later
 */
val zipped = chars.zipWithIndex

zipped.unzip

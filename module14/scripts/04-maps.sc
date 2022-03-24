import scala.collection.mutable
import scala.collection.immutable

val numWords = Map(1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five")
val numWords2 = Map((1 , "one"), Tuple2(2 , "two"), 3 -> "three", 4 -> "four", 5 -> "five")


numWords(1)     // don't use this
//numWords.apply(10)     //java.util.NoSuchElementException: key not found: 10
numWords.get(1) // use this
numWords.getOrElse(1, "?") // or this

val nums = List(1,2,3,2,5)
nums.map(numWords)

for ((num, word) <- numWords) {
  println(s"$num -> $word")
}


val tm = immutable.TreeMap.empty[Int, String] ++ numWords


val mm = mutable.Map.empty[Int, String] ++ numWords

mm -= 2
mm += 2 -> "two"


numWords.keys
numWords.keySet
numWords.values

numWords.filterKeys(_ % 2 == 0)
numWords.mapValues(_.reverse)

numWords.transform { case (k, v) => s"$v($k)" }

numWords.map(_.swap)

val evens = (for (i <- 1 to 5) yield i -> (i % 2 == 0)).toMap

evens.map(_.swap) // coz map is maintaining uniqueness

val m: Map[Int, String] = immutable.HashMap(
  1 -> "hone bache khen",
  2 -> "bee",
  3 -> "hone gis khe"
)

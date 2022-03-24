val nums: List[Int] = List.range(1, 21)

val numsIter: Iterator[Int] = nums.iterator

numsIter.hasNext

// An example of what not to do!
//here, the call to .length exhausts the iterator
//Either stick to .hasNext and .next() or convert to another collection
// if (numsIter.length > 0) numsIter.next()


val vec = Vector.range(0, 20)

val vecView = vec.view

def calcSquare(x: Int): Int = {
  println(s"Calculating for $x")
  x * x
}

val squaresView = vecView.map(calcSquare)

squaresView(2)
squaresView(4)
squaresView(2)

val squares = squaresView.force

squares(2)

squares


val numsFromOne = Stream.from(1)

val firstTenNums = numsFromOne.take(10)
firstTenNums.toList

val powersOfTwo: Stream[Int] = 1 #:: powersOfTwo.map(_ * 2)
powersOfTwo.take(5).toList

val factorial: Stream[BigInt] = BigInt(1) #:: factorial.zip(Stream.from(2)).
  map { case(a, b) => a * b }

val firstTenFacs = factorial.take(10)

firstTenFacs.toList


val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).
  map { case(x, y) => x + y }

fibs.take(20).toList

def fibRecursion(a: Int = 0, b: Int = 1):Stream[Int] = {
  Stream.cons(a, fibRecursion(b, a + b))
}

fibRecursion().take(10).toList

def fibRecIterator(): Stream[Int] = {
  Stream.iterate((0, 1)) { case (a, b) =>
    (b, (a + b))
  }.map(_._1)
}

fibRecIterator().take(10).toList
val simpleStream = Stream.continually(1)
simpleStream.take(10).toList
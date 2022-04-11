import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._

val f = Future { 5 / 0 }
val r: Future[Int] = f  andThen {
     case Failure(t) => t
      case Success(v) => v
    }

Thread.sleep(1000)
r.value

/**
 *  Note that if one of the chained `andThen` callbacks throws
 *  an exception, that exception is not propagated to the subsequent `andThen`
 *  callbacks. Instead, the subsequent `andThen` callbacks are given the original
 *  value of this future.
 */
val f2 = Future { 5 }
  f2 andThen {
      case r: Try[Int] => sys.error("runtime exception")
      } andThen {
     case Failure(t) => t //println(t)
      case Success(v) => 16 //println(v)
    }

f2.value

val xs = List(1,2,3,4)
def func(x: Int) = Future.successful(x + 1)
val r: Future[List[Int]] = Future.traverse(xs)(func)
r.value

val fL: List[Future[Int]] = xs.map(func)
val fL2: Future[List[Int]] = Future.sequence(fL)
fL2.value

val sum: Future[Int] = Future.foldLeft(fL)(0)(_ + _)
sum.value

////
val l: List[Int] = List(1,2,3)
val r: AnyVal = 10

val r = l.reduceLeft[AnyVal](_ + _)
import TypeErasure._

object SealedCC extends App {
  /**
   * sealed class can only be extended in the same file
   */
  //class Land extends Measure(1,2)
  class NewPrice extends Price(1)
}
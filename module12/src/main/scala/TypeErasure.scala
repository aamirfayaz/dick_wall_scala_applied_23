object TypeErasure extends App {
  def erasureCheck(x: Any): Any = x match {
    case l: List[Int] => "hello"
//    case l: List[Int] => l.head - 2
    case _            => "hi"
  }


  erasureCheck(List[Int](1, 2, 3, 4))
  erasureCheck(List[String]("hi", "hello"))

  /**
   * Type erasure does apply there. What's happening is JVM erases the inner types,
   * so it still matches the Map[Int,String]. It gets into that call and does m.head._1, which it assumes is a Int.
   * However, the actual runtime class is String, thus the ClassCastException
   */
  def withIntStringMap(x: Any): Any = x match {
    //case m: Map[Int, String] => "hello"
    case m: Map[Int, String] => m.head._1 - 2
   // case m: Map[_, _] => m.head._1 - 2
    case _                   => 0
  }

  println(withIntStringMap(Map(1 -> "one")))
  withIntStringMap(List(1))
  withIntStringMap(Map("One" -> 1))

}

case class Address(street: String, city: String, postCode: Option[String])
case class Person(name: String, phone: Option[String], address: Option[Address])

val harry = Person("Harry", None, Some(Address(
  "123 Little Whinging way", "Purley", Some("PN22 6RT")
)))

def describeType(x: Any) = x match {
  case i: Int if i > 0 => s"Int ${i * i}"
  case d: Double => s"Double $d"
  case s: String => s"String ${s.reverse}"
  case p: Person => s"Person, name = ${p.name}"
  case _ => "Some other type"
}

describeType(3)
describeType(3.4)
describeType("Hello")
describeType(harry)
describeType(true)


// use type patterns instead of this style:
val s: Any = "Hello"
if (s.isInstanceOf[String]) {
  s.asInstanceOf[String].reverse
}


// but beware type erasure:

def erasureCheck(x: Any): String = x match {
  case _: List[Int] => "hello"
  case _ => "hi"


erasureCheck(List[Int](1,2,3,4))
erasureCheck(List[String]("hi", "hello"))

def withIntStringMap(x: Any): Int = x match {
  case m: Map[Int, String] =>
 // case m: Map[_,_] =>
    m.head._1 match {
      case i: Int => i * i
      case _ => 22
    }
  case _ => 0
}

withIntStringMap(Map(1 -> "one"))
withIntStringMap(List(1))
withIntStringMap(Map("One" -> 1))

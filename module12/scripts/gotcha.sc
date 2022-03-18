val xs = List(1,2,3,4)


//works fine:
val ys = List(1,2)
ys match {
  case List(a, rest) =>
    println(s"a = $a, rest = $rest")
}

xs match {
  case List(a, rest@_*) =>
    println(s"a = $a, rest = $rest")
}

xs match {
  case List(a, rest) =>
    println(s"a = $a, rest = $rest")
}
//MatchError at runtime
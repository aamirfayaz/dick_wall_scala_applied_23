name := "Scala-Applied-Exercises"

version in ThisBuild := "1.0-SNAPSHOT"

//organization := "com.aamir"

//licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

scalaVersion in ThisBuild := "2.12.11"

scalacOptions in ThisBuild += "-deprecation"

//javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

//crossScalaVersions := Seq("2.10.4", "2.12.2")
//%% dowm will compile and bring libraries for all cross scala versions

//libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.4"

libraryDependencies in ThisBuild ++= Seq(
  "org.scalactic"  %% "scalactic"  % "3.0.4",
  "org.scalatest"  %% "scalatest"  % "3.0.4"  % Test,
  "org.scalamock"  %% "scalamock"  % "4.1.0"  % Test,
  "org.scalacheck" %% "scalacheck" % "1.13.4" % Test,
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.8.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
  "com.typesafe.akka" %% "akka-actor" % "2.5.7",
  "com.typesafe.akka" %% "akka-remote" % "2.5.7",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.7" % Test
)

//adding a custom setting
val isAwesome = settingKey[Boolean]("Some boolean setting")
isAwesome := true

val totally = settingKey[String]("rating of totalness of the statement")
totally := "100% totally"

val totallyAwesome = settingKey[String]("how awesome is this project")
totallyAwesome := totally.value + {
  println("checking project awesomness")
  if(isAwesome.value) "awesome." else "not awesome."
}

//add a custom task
lazy val checkAwesome = taskKey[Unit]("check project awesomeness....")

checkAwesome := {
  println("inside task")
  val _ = (compile in Compile).value //force test:compile first, and it should pass
  println("the project is " + totallyAwesome.value)
}

lazy val module12 = project
lazy val module13 = project
lazy val module14 = project
lazy val module15 = project
lazy val module16 = project

lazy val root = project.in(file(".")).
  aggregate(module12, module13, module14, module15, module16)
  .settings(aggregate in update := false)


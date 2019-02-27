enablePlugins(JmhPlugin)

name := "TestString"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.log4s" %% "log4s" % "1.7.0"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"

scalacOptions in Test ++= Seq("-Yrangepos")

cancelable in Scope.Global := true
fork in run := true
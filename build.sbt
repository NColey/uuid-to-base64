ThisBuild / scalaVersion := "2.13.12"
ThisBuild / organization := "io.github.ncoley"

lazy val uuidToBase64 = (project in file("."))
  .settings(
    name := "uuid-to-base64",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15"
  )
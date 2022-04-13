import Versions._
import Dependencies._
import ScalacOptions._

val projectName        = "rockthejvm-http4s-tutorial"
val projectDescription = "Http4s Tutorial by rockthejvm"

ThisBuild / fork                   := true
ThisBuild / turbo                  := true // default: false
ThisBuild / includePluginResolvers := true // default: false
Global / onChangedBuildSource      := ReloadOnSourceChanges

inThisBuild(
  Seq(
    version                  := projectVersion,
    scalaVersion             := scala2Version,
    publish / skip           := true,
    scalacOptions ++= defaultScalacOptions,
    semanticdbEnabled        := true,
    semanticdbVersion        := scalafixSemanticdb.revision,
    scalafixDependencies ++= Seq("com.github.liancheng" %% "organize-imports" % scalafixOrganizeImportsVersion),
    Test / parallelExecution := false,
    // run 100 tests for each property // -s = -minSuccessfulTests
    Test / testOptions += Tests.Argument(TestFrameworks.ScalaCheck, "-s", "100"),
    initialCommands          :=
      s"""|
          |import scala.util.chaining._
          |import scala.concurrent.duration._
          |println()
          |""".stripMargin // initialize REPL
  )
)

lazy val root = (project in file("."))
  // .dependsOn(hutil)
  .settings(
    name                              := projectName,
    description                       := projectDescription,
    Compile / console / scalacOptions := consoleScalacOptions,
    libraryDependencies ++= Seq(
      http4sBlazeServer,
      http4sDsl,
      http4sCirce,
      circeGeneric,
      munit,
      kindProjectorPlugin,
      betterMonadicForPlugin
    ) ++ Seq(
      scalaCheck
    ).map(_ % Test)
  )

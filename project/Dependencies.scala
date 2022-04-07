import sbt._

object Dependencies {

  import Versions._

  lazy val http4sBlazeServer = "org.http4s"     %% "http4s-blaze-server" % http4sVersion
  lazy val http4sCirce       = "org.http4s"     %% "http4s-circe"        % http4sVersion
  lazy val http4sDsl         = "org.http4s"     %% "http4s-dsl"          % http4sVersion
  lazy val circeGeneric      = "io.circe"       %% "circe-generic"       % circeVersion
  lazy val munit             = "org.scalameta"  %% "munit"               % munitVersion
  lazy val scalaCheck        = "org.scalacheck" %% "scalacheck"          % scalaCheckVersion

  // https://github.com/typelevel/kind-projector
  lazy val kindProjectorPlugin    = compilerPlugin(
    compilerPlugin("org.typelevel" % "kind-projector" % kindProjectorVersion cross CrossVersion.full)
  )
  // https://github.com/oleg-py/better-monadic-for
  lazy val betterMonadicForPlugin = compilerPlugin(
    compilerPlugin("com.olegpy" %% "better-monadic-for" % betterMonadicForVersion)
  )
}

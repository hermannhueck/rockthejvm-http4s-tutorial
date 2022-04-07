package demo

import cats.effect.{IO, IOApp}
import hutil.stringformat._

object Http4sDemo extends IOApp.Simple {

  object domain {
    type Actor = String

    case class Movie(id: String, title: String, year: Int, actors: List[String], director: String)

    case class Director(firstName: String, lastName: String) {
      override def toString: String = s"$firstName $lastName"
    }
  }
  import domain._

  val run: IO[Unit] =
    for {
      _ <- IO.println(dash80.green)
      _ <- IO.println("Hello Http4s")
      _ <- IO.println(dash80.green)
    } yield ()
}

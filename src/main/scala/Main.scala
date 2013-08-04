import akka.actor.{Props, ActorSystem}
import akka.pattern.ask
import akka.util.duration._
import akka.util.Timeout

object Main {
  implicit val timeout = Timeout(5 seconds)

  def main(args: Array[String]): Unit = {

    val system = ActorSystem()

    val ref = system.actorOf(Props[HelloActor], name = "helloActor")

    val future = ref ? "World"

    /*
    future onSuccess{
      case _ => println("success")
    }
    */

    future onFailure {
      case e: Exception => e.printStackTrace()
    }

    future onComplete {
      case Right(result) =>
        println(result)
        system.stop(ref)
        sys.exit()
      case Left(failure) => failure.printStackTrace()
    }
  }
}
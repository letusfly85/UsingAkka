package sample

import akka.actor.ActorSystem
import java.util.Properties

object ClientSample {

  def main(args: Array[String]) {
    val properties: Properties = new Properties()
    properties.load(getClass().getResourceAsStream("/.properties"))

    val system = ActorSystem()

    val remoteActor = system.actorFor(
    "akka://RemoteActor@" + properties.getProperty("HOST") + ":" + properties.getProperty("PORT") + "/sample/serverActor"
    )

    remoteActor ! "actorFor"
  }
}
package sample

import akka.actor.ActorSystem
import java.util.Properties

object ClientSample {

  def main(args: Array[String]) {
    val properties: Properties = new Properties()
    properties.load(getClass().getResourceAsStream("/.properties"))

    val host = properties.getProperty("HOST")
    val port = properties.getProperty("PORT")
    val server =  "akka://RemoteActor@" + host + ":" + port + "/user/serverActor"

    val system = ActorSystem()

    val remoteActor = system.actorFor(server)

    val msg = "頑張らないo(▽≦*o))) 効率的にやる（´＿｀＼）"
    remoteActor ! msg

    system.shutdown()
  }
}
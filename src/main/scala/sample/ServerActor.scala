package sample

import akka.actor.{Props, ActorSystem, Actor}

class ServerActor extends Actor {

  def receive = {
    case x => println("execute remote actor: " + x)
  }
}

object ServerMain {

  def main(args: Array[String]) {
    val system = ActorSystem("RemoteActor")

    system.actorOf(Props[ServerActor], "serverActor")
  }

}

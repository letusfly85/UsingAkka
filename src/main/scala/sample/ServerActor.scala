package sample

import akka.actor.{Props, ActorSystem, Actor}

class ServerActor extends Actor {

  def receive = {
    case x: String =>
      println("execute remote actor: " + x)

      val tweet: MyTweet = new MyTweet
      tweet.myTweet(x)

    case y =>
      println(y)
  }
}

object ServerMain {

  def main(args: Array[String]) {
    val system = ActorSystem("RemoteActor")

    system.actorOf(Props[ServerActor], "serverActor")
  }

}

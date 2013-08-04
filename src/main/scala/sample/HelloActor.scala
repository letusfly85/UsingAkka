package sample

import akka.actor._

class HelloActor extends Actor {

  def receive = {

    case s: String =>
        sender ! s + ": message"
    case _ => println("error")

  }

  override def preStart() {
    println("preStart")
  }

  override def postStop() {
    println("postStop")
  }

}
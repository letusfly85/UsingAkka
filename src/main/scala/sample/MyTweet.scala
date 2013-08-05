package sample

import twitter4j.{TwitterException, TwitterFactory, Twitter}
import java.util.Properties
import twitter4j.auth.AccessToken

class MyTweet {

  def myTweet(msg: String) {

    val twitter: Twitter = new TwitterFactory().getInstance()

    try {
      val properties: Properties = new Properties()
      properties.load(getClass.getResourceAsStream("/.properties"))

      val consumerKey: String    = properties.getProperty("CONSUMERKEY")
      val consumerSecret: String = properties.getProperty("CONSUMERSECRET")
      twitter.setOAuthConsumer(consumerKey, consumerSecret)

      val accessTokenKey: String    = properties.getProperty("ACCESSTOKEN")
      val accessTokenSecret: String = properties.getProperty("ACCESSTOKENSECRET")

      val accessToken: AccessToken = new AccessToken(accessTokenKey, accessTokenSecret)
      twitter.setOAuthAccessToken(accessToken)

      twitter.updateStatus("[日替自動投稿]" + msg)

    } catch {
      case e: TwitterException =>
        e.printStackTrace()

    }
  }
}

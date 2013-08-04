package sample

import twitter4j._
import twitter4j.auth.{RequestToken, AccessToken}
import java.util.Properties

object SampleTweet {

  def main(args: Array[String]) {

  val twitter: Twitter = new TwitterFactory().getInstance()

    try {
      val properties: Properties = new Properties()
      properties.load(getClass.getResourceAsStream("/.properties"))

      val consumerKey: String    = properties.getProperty("CONSUMERKEY")
      val consumerSecret: String = properties.getProperty("CONSUMERSECRET")
      twitter.setOAuthConsumer(consumerKey, consumerSecret)

      val accessTokenKey: String    = properties.getProperty("ACCESSTOKEN")
      val accessTokenSecret: String = properties.getProperty("ACCESSTOKENSECRET")

      /*
      val config = new twitter4j.conf.ConfigurationBuilder()
        .setOAuthConsumerKey(consumerKey)
        .setOAuthConsumerSecret(consumerSecret)
        .setOAuthAccessToken(accessTokenKey)
        .setOAuthAccessTokenSecret(accessTokenSecret)
      */
      //val _twitter = new TwitterFactory(config).getInstance()



      val accessToken: AccessToken = new AccessToken(accessTokenKey, accessTokenSecret)
      twitter.setOAuthAccessToken(accessToken)

      for (i <- 1 to 10) {
        Thread.sleep(1000)
        i match {
          case 1 =>
            twitter.updateStatus("私はまじめに仕事にいそしんでいます。")

          case 2 =>
            twitter.updateStatus("私は勤勉な社会人です。")

          case 3 =>
            twitter.updateStatus("私は仲間を大切にします。")

          case 4 =>
            twitter.updateStatus("私は常に誠実であろうと心がけています。")

          case 5 =>
            twitter.updateStatus("月曜日、、、、、")

          case _ =>
            twitter.updateStatus("あきたなー。")

        }
        //twitter.updateStatus("これは"  + i.toString + " 回目の会社向けキャラ作りのための自動ツィート投稿テストです。")
      }

    } catch {
      case e: TwitterException =>
        e.printStackTrace()

    }
  }
}

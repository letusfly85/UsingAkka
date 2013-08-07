package com.jellyfish85.financial.tool.collectTweet

import twitter4j.{TwitterFactory, Twitter}
import java.util.Properties
import twitter4j.auth.AccessToken

class TweetClient {

  /**
   *
   *
   * @return twitter client
   */
  def myTwitter: Twitter  = {
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

    }
    twitter
  }
}

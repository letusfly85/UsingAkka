package com.jellyfish85.financial.tool.collectTweet

import twitter4j._

object ShowWallStreetTweets {

  def main(args: Array[String]) = {

    val myTweet: Twitter = (new TweetClient).myTwitter

    val geo: GeoLocation = new GeoLocation(40.706001, -74.008819)
    val query: Query = new Query()

    query.setGeoCode(geo, 10.0, Query.KILOMETERS)

    val result: QueryResult = myTweet.search(query)

    var flg: Boolean = true
    var snippet: String = ""
    while (flg) {
      val contents: java.util.List[Status] = result.getTweets
      if (contents.isEmpty) flg = false

      for (i <- 0 to contents.size()-1) {
        snippet = "[WallStreetArea]" + contents.get(i).getText()
        if (snippet.length > 140) snippet = snippet.substring(0,135)
        //if (snippet.matches("money")) {println(snippet)}
        if (i/100 == 0) {

          println(snippet)
          myTweet.updateStatus(snippet)
        }
        if (i > 1000000) {
          sys.exit()
        }

        Thread.sleep(10000)
      }
    }
  }

}

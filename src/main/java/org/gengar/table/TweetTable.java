package org.gengar.table;

import org.gengar.model.Tweet;

import java.util.HashMap;
import java.util.Map;

public class TweetTable {
    private final Map<Integer, Tweet> tweetTable = new HashMap<>();
    private static TweetTable tweetTableInstance;
    public static TweetTable getInstance() {
        if(tweetTableInstance == null) {
            tweetTableInstance = new TweetTable();
        }
        return tweetTableInstance;
    }
    public Map<Integer, Tweet> getTweetTable() {
        return tweetTable;
    }
    public void addTweet(Tweet tweet) {
        tweetTable.put(tweet.getTweetId(), tweet);
    }

    public Tweet getTweet(Integer tweetId) {
        return tweetTable.get(tweetId);
    }
}

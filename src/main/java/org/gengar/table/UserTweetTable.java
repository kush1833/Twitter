package org.gengar.table;

import org.gengar.model.Tweet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTweetTable {
    private final Map<Integer, List<Tweet>> userTweetTable = new HashMap<>();
    private static UserTweetTable userTweetTableInstance;
    public static UserTweetTable getInstance() {
        if(userTweetTableInstance == null) {
            userTweetTableInstance = new UserTweetTable();
        }
        return userTweetTableInstance;
    }
    public List<Tweet> getUserTweets(int userId) {
        return userTweetTable.get(userId);
    }
    public void addUserTweet(int userId, Tweet tweet) {
        userTweetTable.putIfAbsent(userId, new ArrayList<>());
        List<Tweet> userTweets = userTweetTable.get(userId);
        userTweets.add(tweet);
        userTweetTable.put(userId, userTweets);
    }
}

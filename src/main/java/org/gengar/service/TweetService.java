package org.gengar.service;

import org.gengar.model.Follow;
import org.gengar.model.Tweet;
import org.gengar.table.FollowTable;
import org.gengar.table.TweetTable;
import org.gengar.table.UserTweetTable;
import org.gengar.validation.TweetContentValidationRule;
import org.gengar.validation.ValidationRule;

import java.util.*;

public class TweetService {
    private static int tweetId = 0;
    private final List<ValidationRule> validationRules;
    public TweetService() {
        this.validationRules = new ArrayList<>();
        validationRules.add(new TweetContentValidationRule());
    }

    public Tweet postTweet(int userId, String tweetContent) {
        for(ValidationRule rule : validationRules) {
            List<String> errors = rule.validate(tweetContent);
            if(!errors.isEmpty()) {
                System.out.println("Tweet content is invalid. Errors: \n");
                for(String error : errors) {
                    System.out.println(error + "\n");
                }
                return null;
            }
        }
        Tweet tweet = new Tweet();
        tweet.setUserId(userId);
        tweet.setTweetId(tweetId++);
        tweet.setTweetContent(tweetContent);
        Date date = new Date();
        tweet.setCreatedAt(date);
        tweet.setUpdatedAt(date);
        TweetTable.getInstance().addTweet(tweet);
        UserTweetTable.getInstance().addUserTweet(userId, tweet);
        return tweet;
    }
    public List<Tweet> getNewsFeed(int userId) {
        Follow followInfo = FollowTable.getInstance()
                .getFollowInfo(userId);
        if(followInfo == null) {
            System.out.println("User is not following anyone");
            return Collections.emptyList();
        }
        else {
            List<Integer> followingList = followInfo.getFollowing();
            List<Tweet> newsFeed = new ArrayList<>();
            for (int following : followingList) {
                newsFeed.addAll(Optional.ofNullable(
                        UserTweetTable.getInstance().getUserTweets(following)).orElse(Collections.emptyList())
                );
            }
            newsFeed.sort((t1, t2) -> t2.getCreatedAt().compareTo(t1.getCreatedAt()));
            return newsFeed;
        }
    }
    public void likeTweet(int tweetId) {
        Tweet tweet = TweetTable.getInstance().getTweet(tweetId);
        tweet.setLikes(tweet.getLikes() + 1);
    }
}

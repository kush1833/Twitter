package org.gengar.service;

import org.gengar.model.Tweet;

import java.util.List;

public class TwitterService {
    private final UserService userService;
    private final TweetService tweetService;
    private final FollowService followService;
    public TwitterService() {
        this.userService = new UserService();
        this.tweetService = new TweetService();
        this.followService = new FollowService();
    }
    public boolean createUser(String name, String email, String password) {
        return userService.createUser(name, email, password) != null;
    }
    public boolean postTweet(int userId, String tweetContent) {
        return tweetService.postTweet(userId, tweetContent) != null;
    }

    /**
     * Follow a user
     * @param userId user to be followed
     * @param followerId user who is following
     * @return true if the user is followed successfully
     */
    public boolean followUser(int userId, int followerId) {
        return followService.followUser(userId, followerId);
    }
    public boolean unfollowUser(int userId, int followerId) {
        return followService.unfollowUser(userId, followerId);
    }
    public List<Tweet> getNewsFeed(int userId) {
        return tweetService.getNewsFeed(userId);
    }
    public void likeTweet(int tweetId) {
        tweetService.likeTweet(tweetId);
    }
}

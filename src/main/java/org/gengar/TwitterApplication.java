package org.gengar;

import org.gengar.service.TwitterService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwitterApplication {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Twitter!");
        TwitterService twitterService = new TwitterService();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;
        while(!exit) {
            System.out.println("1. Create User");
            System.out.println("2. Create Tweet");
            System.out.println("3. Follow User");
            System.out.println("4. Unfollow User");
            System.out.println("5. View Feeds");
            System.out.println("6. Like Tweet");
            System.out.println("7. Exit");
            String choice = bufferedReader.readLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter name, email and password");
                    String[] input = bufferedReader.readLine().split(" ");
                    if(twitterService.createUser(input[0], input[1], input[2])) {
                        System.out.println("User created successfully");
                    } else {
                        System.out.println("User creation failed");
                    }
                    break;
                case "2":
                    System.out.println("Enter userId");
                    int userIdOfTweeter = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Enter tweet content");
                    String tweetContent = bufferedReader.readLine();
                    if(twitterService.postTweet(userIdOfTweeter, tweetContent)) {
                        System.out.println("Tweet posted successfully");
                    } else {
                        System.out.println("Tweet posting failed");
                    }
                    break;
                case "3":
                    System.out.println("Enter userId to follow");
                    int userIdToFollow = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Enter followerId");
                    int followerId = Integer.parseInt(bufferedReader.readLine());
                    if(twitterService.followUser(userIdToFollow, followerId)) {
                        System.out.println("User followed successfully");
                    } else {
                        System.out.println("User follow failed");
                    }
                    break;
                case "4":
                    System.out.println("Enter userId to unfollow");
                    int userIdToUnfollow = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Enter followerId");
                    int followerIdToRemove = Integer.parseInt(bufferedReader.readLine());
                    if(twitterService.unfollowUser(userIdToUnfollow, followerIdToRemove)) {
                        System.out.println("User unfollowed successfully");
                    } else {
                        System.out.println("User unfollow failed");
                    }
                    break;
                case "5":
                    System.out.println("Enter userId to view feeds for");
                    int userId = Integer.parseInt(bufferedReader.readLine());
                    twitterService.getNewsFeed(userId).forEach(tweet -> {
                        System.out.println("TweetContent: " + tweet.getTweetContent()
                                + "\nLikes: " + tweet.getLikes()
                                + "\nCreatedAt: " + tweet.getCreatedAt()
                                + "\nUpdatedAt: " + tweet.getUpdatedAt()
                        );
                    });
                    break;
                case "6":
                    System.out.println("Enter tweetId to like");
                    int tweetId = Integer.parseInt(bufferedReader.readLine());
                    twitterService.likeTweet(tweetId);
                    break;
                case "7":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        System.out.println("Exiting Twitter!");
    }
}

package org.gengar.service;

import org.gengar.model.Follow;
import org.gengar.table.FollowTable;

public class FollowService {
    public boolean followUser(int userId, int follower) {
        FollowTable followTable = FollowTable.getInstance();
        if(followTable.hasUser(userId)) {
            Follow follow = followTable.getFollowInfo(userId);
            follow.addFollower(follower);
        }
        else {
            Follow follow = new Follow();
            follow.setUserId(userId);
            follow.addFollower(follower);
            followTable.addFollowInfo(follow);
        }
        if(followTable.hasUser(follower)) {
            Follow follow = followTable.getFollowInfo(follower);
            follow.addFollowing(userId);
        }
        else {
            Follow follow = new Follow();
            follow.setUserId(follower);
            follow.addFollowing(userId);
            followTable.addFollowInfo(follow);
        }
        return true;
    }
    public boolean unfollowUser(int userId, int follower) {
        Follow follow = FollowTable.getInstance().getFollowInfo(userId);
        follow.getFollowers().remove(follower);
        follow = FollowTable.getInstance().getFollowInfo(follower);
        follow.getFollowing().remove(userId);
        return true;
    }
}

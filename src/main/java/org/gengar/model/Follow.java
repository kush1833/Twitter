package org.gengar.model;

import java.util.ArrayList;
import java.util.List;

public class Follow {
    private int userId;
    private final List<Integer> followers = new ArrayList<>();
    private final List<Integer> following = new ArrayList<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public void addFollower(Integer follower) {
        this.followers.add(follower);
    }

    public List<Integer> getFollowing() {
        return following;
    }
    public void addFollowing(Integer following) {
        this.following.add(following);
    }
}

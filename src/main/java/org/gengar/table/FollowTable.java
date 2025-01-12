package org.gengar.table;

import org.gengar.model.Follow;

import java.util.HashMap;
import java.util.Map;

public class FollowTable {
    private final Map<Integer, Follow> followTable = new HashMap<>();
    private static FollowTable followTableInstance;
    public static FollowTable getInstance() {
        if(followTableInstance == null) {
            followTableInstance = new FollowTable();
        }
        return followTableInstance;
    }
    public Follow getFollowInfo(int userId) {
        return followTable.get(userId);
    }
    public void addFollowInfo(Follow follow) {
        followTable.put(follow.getUserId(), follow);
    }
    public boolean hasUser(int userId) {
        return followTable.containsKey(userId);
    }
}

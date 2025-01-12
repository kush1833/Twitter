package org.gengar.table;

import org.gengar.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserTable {
    private final Map<Integer, User> userTable = new HashMap<>();
    private static UserTable userTableInstance;
    public static UserTable getInstance() {
        if(userTableInstance == null) {
            userTableInstance = new UserTable();
        }
        return userTableInstance;
    }
    public User getUser(int userId) {
        return userTable.get(userId);
    }
    public void addUser(User user) {
        userTable.put(user.getUserId(), user);
    }
}

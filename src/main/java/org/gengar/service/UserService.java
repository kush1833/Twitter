package org.gengar.service;

import org.gengar.model.User;
import org.gengar.table.UserTable;

public class UserService {
    private static int userId = 0;
    public User createUser(String name, String email, String password) {
        User user = new User();
        user.setUserId(userId++);
        user.setEmail(email);
        user.setUserName(name);
        user.setPassword(password);
        UserTable.getInstance().addUser(user);
        return user;
    }
}

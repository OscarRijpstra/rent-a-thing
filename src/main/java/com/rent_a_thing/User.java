package com.rent_a_thing;

import java.util.ArrayList;

public class User {
    private static final ArrayList<User> USERS = new ArrayList<User>();
    private static User currentUser;
 
    private String username;
    private String password;

    public User(String username, String password) {
        // TODO: check if user does not exists
        this.username = username;

        // TODO: encrypt password
        this.password = password;

        USERS.add(this);
    }

    public static User getCurrentLoggedinUser() {
        return currentUser;
    }

    public static void signIn(String username, String password) {
        for (User user : USERS) {
            // TODO: check encrypted password
            if (user.username.equals(username) && user.password.equals(password)) {
                currentUser = user;
            }
        }
    }

    public static void signOut() {
        currentUser = null;
    }
}

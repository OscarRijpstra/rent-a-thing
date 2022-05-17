package com.rent_a_thing;

import java.util.ArrayList;

public class User {
    private static final ArrayList<User> USERS = new ArrayList<User>();
 
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

        USERS.add(this);
    }
}

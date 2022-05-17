package com.rent_a_thing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SignInTest {
    @Test
    public void credentialsAreValid() {
        new User("tom", "wandel");

        User.signIn("",  "");
        assertNull(User.getCurrentLoggedinUser());

        User.signIn("tom",  "wande");
        assertNull(User.getCurrentLoggedinUser());

        User.signIn("to",  "wande");
        assertNull(User.getCurrentLoggedinUser());

        User.signIn("tom",  "wandel");
        assertNotNull( User.getCurrentLoggedinUser());
    }
}

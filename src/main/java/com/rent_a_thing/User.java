package com.rent_a_thing;

import java.util.ArrayList;

public abstract class User { 
    private String firstname;
    private String lastname;
    private String role;

    public User(String firstname, String lastname, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getRole() {
        return this.role;
    }

    @Override
    public String toString() {
        return "Gebruiker: " + getFirstname() + " " + getLastname();
    }
}

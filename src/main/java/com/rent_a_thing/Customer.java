package com.rent_a_thing;

import java.util.ArrayList;

public class Customer {
    private static final ArrayList<Customer> CUSTOMERS = new ArrayList<Customer>();

    private String firstname;
    private String lastname;

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

        CUSTOMERS.add(this);
    }
}

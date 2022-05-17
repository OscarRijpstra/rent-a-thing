package com.rent_a_thing;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RentHistory {
    private static final ArrayList<RentHistory> RENTHISTORY = new ArrayList<RentHistory>();

    private Customer customer;
    private User employee;
    private Product product;
    private LocalDateTime startdate;
    private LocalDateTime enddate;

    public RentHistory(Customer customer, User employee, Product product) {
        this.customer = customer;
        this.employee = employee;
        this.product = product;
        this.startdate = LocalDateTime.now();
        this.enddate = LocalDateTime.MIN;

        RENTHISTORY.add(this);
    }
}

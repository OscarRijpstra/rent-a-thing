package com.rent_a_thing;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RentHistory {
    private static final ArrayList<RentHistory> RENTHISTORY = new ArrayList<RentHistory>();

    private Customer customer;
    private User employee;
    private Product product;
    private LocalDateTime startdate;

    public RentHistory(Customer customer, User employee, Product product) {
        this.customer = customer;
        this.employee = employee;
        this.product = product;
        this.startdate = LocalDateTime.now();

        RENTHISTORY.add(this);
    }

    public static Integer countRentals(Customer customer) {
        Integer rentedCount = 0;

        for (RentHistory history : RENTHISTORY) {
            if (customer == history.customer) {
                rentedCount++;
            }
        }

        return rentedCount;
    }
}

package com.rent_a_thing;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Rent {
    private static final ArrayList<Rent> RENTHISTORY = new ArrayList<Rent>();

    private Customer customer;
    private Employee employee;
    private Product product;
    private LocalDateTime startdate;
    private LocalDateTime enddate;

    public Rent(Customer customer, Product product) throws Exception {
        Employee employee = Employee.getLoggedInUser();

        if (employee == null) {
            throw new Exception("Er is geen medewerker ingelogd");
        }

        if(!productIsAvailable(product)) {
            throw new Exception("Dit product wordt al verhuurd");
        }

        this.customer = customer;
        this.employee = employee;
        this.product = product;
        this.startdate = LocalDateTime.now();
        this.enddate = null;

        RENTHISTORY.add(this);
    }

    public LocalDateTime getEndDate() {
        return this.enddate;
    }

    public static Rent getLastRented(Product product) {
        for (Rent rent : RENTHISTORY) {
            if (rent.product == product && rent.enddate == null) return rent;
        }
        return null;
    }

    public static Boolean productIsAvailable(Product product) {
        Rent rented = getLastRented(product);
        if (rented == null) return true;
        return rented.enddate != null;
    }

    public static void handIn(Product product) {
        Rent rented = getLastRented(product);
        rented.enddate = LocalDateTime.now();
    }
}

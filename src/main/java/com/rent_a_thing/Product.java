package com.rent_a_thing;

import java.util.ArrayList;

public class Product {
    private static final ArrayList<Product> PRODUCTS = new ArrayList<Product>();

    private String brand;
    private String model;
    private Boolean isRented;
    private Double dailyPrice;
    private Double weight;
     
    public Product(String brand, String model, Double dailyPrice, Double weight) {
        this.brand = brand;
        this.model = model;
        this.dailyPrice = dailyPrice;
        this.weight = weight;
        this.isRented = false;

        PRODUCTS.add(this);
    }

    public Boolean isRented() {
        return this.isRented;
    }

    public void rent(Customer customer) {
        if (isRented) {
            return;
        }
        
        User currentLoggedInUser = User.getCurrentLoggedinUser();
        if (customer == null || currentLoggedInUser == null) {
            return;
        }

        this.isRented = true;
        new RentHistory(customer, currentLoggedInUser, this);
    }

    public void return_() {
        this.isRented = false;   
    }
}

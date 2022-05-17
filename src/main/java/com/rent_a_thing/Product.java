package com.rent_a_thing;

import java.util.ArrayList;

public class Product {
    private static final ArrayList<Product> PRODUCTS = new ArrayList<Product>();

    private String brand;
    private String model;
    private Boolean isRented;
    private Float dailyPrice;
    private Float weight;
     
    public Product(String brand, String model, Float dailyPrice, Float weight) {
        this.brand = brand;
        this.model = model;
        this.dailyPrice = dailyPrice;
        this.weight = weight;

        PRODUCTS.add(this);
    }

    public void rent() {
        this.isRented = true;
    }

    public void return_() {
        this.isRented = false;   
    }
}

package com.rent_a_thing;

import java.util.ArrayList;

public class Product {
    private static final ArrayList<Product> PRODUCTS = new ArrayList<Product>();
     
    public Product() {
        PRODUCTS.add(this);
    }
}
package com.rent_a_thing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RentalTest {
    @Test
    public void productCanBeRented() {
        Customer customer = new Customer("Test", "Persoon");
        Product product = new Product("Audi", "S5", 100.00, 2500.00);
        assertFalse(product.isRented());
        product.rent(customer);
        assertTrue(product.isRented());
    }
}

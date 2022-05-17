package com.rent_a_thing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RentalTest {
    @Test
    public void productCanBeRented() {
        Product product = new Product("Audi", "S5", 100.00, 2500.00);
        product.rent(null);
        assertFalse(product.isRented());

        Customer customer = new Customer("Test", "Persoon");
        product.rent(customer);
        assertFalse(product.isRented());

        new User("tom", "wandel");
        User.signIn("tom",  "wandel");
        product.rent(customer);

        assertTrue(product.isRented());
    }
}

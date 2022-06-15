package com.rent_a_thing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestRentProduct {
    @Test
    public void testRentProduct() throws Exception {
        Product testProduct = new Product();
        Employee testEmployee = new Employee("Ton", "Bakker", "ton", "abc");
        Customer testCustomer = new Customer("Jan", "Janssen");

        new Rent(testCustomer, testEmployee, testProduct);
        assertFalse(Rent.productIsAvailable(testProduct));

        Rent.handIn(testProduct);
    }

    @Test
    public void testRentUnavailableProduct() throws Exception {
        Product testProduct = new Product();
        Employee testEmployee = new Employee("Ton", "Bakker", "ton", "abc");
        Customer testCustomer = new Customer("Jan", "Janssen");

        new Rent(testCustomer, testEmployee, testProduct);

        try {
            // try to rent the same product without it is returned
            new Rent(testCustomer, testEmployee, testProduct);

            // if it passed, the test fails
            assertTrue(false);
        } catch (Exception e) {
            // else it pass
            assertTrue(true);
        }

        Rent.handIn(testProduct);
    }

    @Test
    public void testHandInProduct() throws Exception {
        Product testProduct = new Product();
        Employee testEmployee = new Employee("Ton", "Bakker", "ton", "abc");
        Customer testCustomer = new Customer("Jan", "Janssen");

        new Rent(testCustomer, testEmployee, testProduct);

        Rent.handIn(testProduct);
        
        assertTrue(Rent.productIsAvailable(testProduct));
    }
}

package com.rent_a_thing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestRentProduct {
    @Test
    public void testProductAvailability() throws Exception {
        Product testProduct = new Product();
        Employee testEmployee = new Employee("Ton", "Bakker", "ton", "abc");
        Customer testCustomer = new Customer("Jan", "Janssen");

        new Rent(testCustomer, testProduct);

        Rent lastRented = Rent.getLastRented(testProduct);
        
        assertNull(lastRented.getEndDate());

        Rent.handIn(testProduct);
    }

    @Test
    public void testRentProduct() throws Exception {
        Product testProduct = new Product();
        new Employee("Ton", "Bakker", "ton", "abc");
        Customer testCustomer = new Customer("Jan", "Janssen");

        try {
            new Rent(testCustomer, testProduct);
            
            // product kon WEL gehuurd worden zonder dat er een medewerker is ingelogd -> fail
            assertTrue(false);
        } catch (Exception e) { /* OK */ }

        // Log medewerker in
        Employee.signIn("ton", "abc");
        
        try {
            // Huur zelfde product nogmaals zonder dat het is ingeleverd
            new Rent(testCustomer, testProduct);
            new Rent(testCustomer, testProduct);
            
            // product kon WEL gehuurd worden terwijl die al verhuurd wordt -> fail
            assertTrue(false);
        } catch (Exception e) {
            Rent.handIn(testProduct);
        }

        new Rent(testCustomer, testProduct);

        assertFalse(Rent.productIsAvailable(testProduct));

        Rent.handIn(testProduct);
    }

    @Test
    public void testRentUnavailableProduct() throws Exception {
        Product testProduct = new Product();
        Employee testEmployee = new Employee("Ton", "Bakker", "ton", "abc");
        Customer testCustomer = new Customer("Jan", "Janssen");

        new Rent(testCustomer, testProduct);

        try {
            // try to rent the same product without it is returned
            new Rent(testCustomer, testProduct);

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

        new Rent(testCustomer, testProduct);

        Rent.handIn(testProduct);
        
        assertTrue(Rent.productIsAvailable(testProduct));
    }
}

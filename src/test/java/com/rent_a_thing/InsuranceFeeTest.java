package com.rent_a_thing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InsuranceFeeTest {
    @Test
    public void calculateInsuranceFee() {
        Product product1 = new Product("Audi", "S5", 120.00, 2500.00, "car");

        Customer customer1 = new Customer("Test", "Persoon");
        new User("tom", "wandel");
        User.signIn("tom", "wandel");
        product1.rent(customer1);
        product1.return_();

        product1.rent(customer1);
        product1.return_();

        Double product1Fee = product1.getDailyPrice() * 0.15 * 1.3 * 1.2;

        // # 1
        assertEquals(product1.calculateInsuranceFee(customer1), product1Fee);

        Product product2 = new Product("Vespa", "Sprint", 80.00, 2500.00, "scooter");
        Customer customer2 = new Customer("Test2", "Jans");
        new User("bart", "neerhof");
        User.signIn("bart", "neerhof");
        product2.rent(customer2);
        product2.return_();

        product2.rent(customer2);
        product2.return_();

        Double product2Fee = product2.getDailyPrice() * 0.15;

        // # 2
        assertEquals(product2.calculateInsuranceFee(customer2), product2Fee);

        for (int i = 0; i <= 4; i++) {
            product1.rent(customer1);
            product1.return_();
        }

        Product product3 = new Product("Susuki", "A5", 50.00, 2500.00, "car");        
        Double product3Fee = product3.getDailyPrice() * 0.1 * 1.3;
        
        // # 3
        assertEquals(product3.calculateInsuranceFee(customer1), product3Fee);

        for (int i = 0; i <= 4; i++) {
            product1.rent(customer2);
            product1.return_();
        }

        Product product4 = new Product("Vespa", "Sprint", 110.00, 2500.00, "scooter");        
        Double product4Fee = product4.getDailyPrice() * 0.1 * 1.2;
        
        // # 4
        assertEquals(product4.calculateInsuranceFee(customer2), product4Fee);

        for (int i = 0; i <= 4; i++) {
            product1.rent(customer1);
            product1.return_();
        }

        Double test5Fee = product1.getDailyPrice() * 0.05 * 1.3 * 1.2;

        // # 5
        assertEquals(product1.calculateInsuranceFee(customer1), test5Fee);

        // # 6

        for (int i = 0; i <= 4; i++) {
            product1.rent(customer2);
            product1.return_();
        }

        Double test6Fee = product2.getDailyPrice() * 0.05;

        assertEquals(product2.calculateInsuranceFee(customer2), test6Fee);
        
        User.signOut();
    }
}

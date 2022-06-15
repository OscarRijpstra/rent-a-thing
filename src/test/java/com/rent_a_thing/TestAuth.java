package com.rent_a_thing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TestAuth {
    @Test
    public void TestSignIn() {
        Employee employee = new Employee("Ben", "Derksen", "ben", "123");
        Employee.signIn("ben", "123");

        assertEquals(Employee.getLoggedInUser(), employee);
    }

    @Test
    public void TestSignOut() {
        new Employee("Ben", "Derksen", "ben", "123");
        Employee.signIn("ben", "123");
        Employee.signOut();

        assertEquals(Employee.getLoggedInUser(), null);
    }
}

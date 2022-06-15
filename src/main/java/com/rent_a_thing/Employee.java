package com.rent_a_thing;

import java.util.ArrayList;

public class Employee extends User {
    
    private String username;
    private String password;
    private static Employee loggedInUser;
    private static final ArrayList<Employee> EMPLOYEES = new ArrayList<Employee>();

    public Employee(String firstname, String lastname, String username, String password) {
        super(firstname, lastname, "employee");
        this.username = username;
        this.password = password;
        EMPLOYEES.add(this);
    }

    public String getUsername() {
        return this.username;
    }

    public static void signIn(String username, String password) {
        for (Employee employee : EMPLOYEES) {
            
            // TODO: check encrypted password
            if (employee.username.equals(username) && employee.password.equals(password)) {
                loggedInUser = employee;
            }
        }
    }

    public static void signOut() {
        loggedInUser = null;
    }

    public static Employee getLoggedInUser()
    {
        return loggedInUser;
    }
}

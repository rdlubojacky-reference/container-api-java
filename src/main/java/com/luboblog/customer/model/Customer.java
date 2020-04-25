package com.luboblog.customer.model;

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    public int id;

    public String firstName;
    public String lastName;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName='%s', lastName='%s']",
         id, firstName, lastName);
    }
}
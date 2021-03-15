package com.company.entity;

public class Person {
    private String firstName;
    private String lastName;
    private String year;

    public Person(String firstName, String lastName, String year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getYear() {
        return year;
    }
}

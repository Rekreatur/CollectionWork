package com.company.comparator;

import com.company.entity.Person;

import java.util.Comparator;

public class sortByLastName implements Comparator<Person> {
    public int compare(Person a, Person b) {
        return a.getLastName().compareTo(b.getLastName());
    }
}

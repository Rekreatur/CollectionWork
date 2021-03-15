package com.company.comparator;

import com.company.entity.Person;

import java.util.Comparator;

public class sortByYear implements Comparator<Person> {
    public int compare(Person a, Person b) {
        return Integer.parseInt(a.getYear()) - Integer.parseInt(b.getYear());
    }
}

package com.company.work;

import com.company.comparator.sortByFirstName;
import com.company.comparator.sortByLastName;
import com.company.comparator.sortByYear;
import com.company.entity.Person;

import java.util.ArrayList;
import java.util.Collections;

public class mechanism {

    private ArrayList<Person> filterFirstName(ArrayList<Person> personArrayList, String firstName) {
        ArrayList<Person> newPersonArrayList = new ArrayList<>();
        for (Person p : personArrayList) {
            if (p.getFirstName().equals(firstName)) {
                newPersonArrayList.add(p);
            }
        }
        return newPersonArrayList;
    }

    private ArrayList<Person> filterLastName(ArrayList<Person> personArrayList, String lastName) {
        ArrayList<Person> newPersonArrayList = new ArrayList<>();
        for (Person p : personArrayList) {
            if (p.getLastName().equals(lastName)) {
                newPersonArrayList.add(p);
            }
        }
        return newPersonArrayList;
    }

    private ArrayList<Person> filterYear(ArrayList<Person> personArrayList, String year) {
        ArrayList<Person> newPersonArrayList = new ArrayList<>();
        for (Person p : personArrayList) {
            if (p.getYear().equals(year)) {
                newPersonArrayList.add(p);
            }
        }
        return newPersonArrayList;
    }

    private ArrayList<Person> filter(ArrayList<Person> personArrayList, String firstName, String lastName, String year) {
        ArrayList<Person> firstNameFilter = new ArrayList<>();
        ArrayList<Person> lastNameFilter = new ArrayList<>();
        ArrayList<Person> yearFilter = new ArrayList<>();

        if (!firstName.equals("")) {
            firstNameFilter = filterFirstName(personArrayList, firstName);

            if (lastName.isEmpty() && year.isEmpty()) {
                return firstNameFilter;
            }
        }

        if (!lastName.equals("")) {
            if (!firstNameFilter.isEmpty()) {
                lastNameFilter = filterLastName(firstNameFilter, lastName);
                if (year.isEmpty()) {
                    return lastNameFilter;
                }
            } else if (firstNameFilter.isEmpty()) {
                lastNameFilter = filterLastName(personArrayList, lastName);
                if (year.isEmpty()) {
                    return lastNameFilter;
                }
            }
        }

        if (!year.equals("")) {
            if (!lastNameFilter.isEmpty()) {
                yearFilter = filterYear(lastNameFilter, year);
                return yearFilter;
            }

            if (lastNameFilter.isEmpty()) {
                if (!firstNameFilter.isEmpty()) {
                    yearFilter = filterYear(firstNameFilter, year);
                    return yearFilter;
                }
                if (firstNameFilter.isEmpty()) {
                    yearFilter = filterYear(personArrayList, year);
                    return yearFilter;
                }
            }
        }
        return personArrayList;
    }

    private ArrayList<Person> sorted(ArrayList<Person> personArrayList, String sortedField, String order) {
        if (sortedField.equals("firstName")) {
            if (order.equals("direct")) {
                Collections.sort(personArrayList, new sortByFirstName());
            }
            if (order.equals("reverse")) {
                Collections.sort(personArrayList, new sortByFirstName().reversed());
            }
        }

        if (sortedField.equals("lastName")) {
            if (order.equals("direct")) {
                Collections.sort(personArrayList, new sortByLastName());
            }
            if (order.equals("reverse")) {
                Collections.sort(personArrayList, new sortByLastName().reversed());
            }
        }

        if (sortedField.equals("year")) {
            if (order.equals("direct")) {
                Collections.sort(personArrayList, new sortByYear());
            }
            if (order.equals("reverse")) {
                Collections.sort(personArrayList, new sortByYear().reversed());
            }
        }

        return personArrayList;
    }

    private ArrayList<Person> page(ArrayList<Person> personArrayList, int size, int page) throws IndexOutOfBoundsException {
        ArrayList<Person> newPersonArrayList = new ArrayList<>();
        try {
            for (int i = size * page - size; i <= size * page - 1; i++) {
                newPersonArrayList.add(personArrayList.get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            return newPersonArrayList;
        }

        return newPersonArrayList;
    }

    public ArrayList<Person> work(ArrayList<Person> personArrayList, String firstName, String lastName, String year, String sortedField, String order, int size, int page) {
        ArrayList<Person> newPersonArrayList = sorted(filter(personArrayList, firstName, lastName, year), sortedField, order);
        return page(newPersonArrayList, size, page);
    }
}

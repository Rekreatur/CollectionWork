package com.company;

import com.company.entity.Person;
import com.company.work.mechanism;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person("Qq", "Semen", "1900"));
        personArrayList.add(new Person("Pvp", "Arkadiy", "1920"));
        personArrayList.add(new Person("Loo", "Greg", "1920"));
        personArrayList.add(new Person("Pvp", "Slava", "1910"));
        personArrayList.add(new Person("Kio", "Semen", "1920"));
        personArrayList.add(new Person("Power", "Lusya", "1940"));
        personArrayList.add(new Person("Avp", "Dred", "1800"));
        personArrayList.add(new Person("Pl", "Ret", "1850"));
        personArrayList.add(new Person("Lock", "Ceva", "2000"));
        personArrayList.add(new Person("Grim", "Grey", "2080"));

        mechanism Mechanism = new mechanism();
        for (Person p : Mechanism.work(personArrayList, "", "", "", "firstName", "direct", 20, 1)) {
            System.out.println(p.getFirstName() + " " + p.getLastName() + " " + p.getYear());
        }
    }
}

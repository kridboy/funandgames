package com.keisse.test.moatje.models;

import java.util.List;

public class Manager extends Person {
    String departement;

    public boolean banUser(String username, List<Person> people) {
        for (Person p : people)
            if (username.equals(p.getUsername())) {
                p.setBanned(true);
                System.err.println("USER: " + p.getUsername() + " has been banned!");
                return true;
            }
        System.out.println("No one was banned");
        return false;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }
}

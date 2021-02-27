package com.keisse.test.moatje.models;

public class Person extends User {
    private String firstName;
    private String familyName;
    int age;

    public boolean create(String firstName, String familyName) {
        setFirstName(firstName);
        setFamilyName(familyName);
        return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", type='" + this.getClass().getName() + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

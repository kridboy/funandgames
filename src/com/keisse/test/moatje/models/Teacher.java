package com.keisse.test.moatje.models;

import java.util.List;

public class Teacher extends Person {
    List<Student> students;

    public void sendMessageToAll(String msg) {
        System.out.println("Students. " + msg);
    }

    public void sendMessageToStudent(String msg, Student s) {
        System.out.println("Hey, " + s.getFirstName() + ". " + msg);
    }
}

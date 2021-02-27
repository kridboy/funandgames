package com.keisse.test.moatje.models;

public class Student extends Person {
    String classCode;

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public void sendMessage(String msg) {
        System.out.println(msg);
    }

}

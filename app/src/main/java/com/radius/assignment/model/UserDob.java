package com.radius.assignment.model;

public class UserDob {
    private String date;
    private int age;

    public UserDob() {
    }

    public UserDob(String date, int age) {
        this.date = date;
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

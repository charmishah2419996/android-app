package com.radius.assignment.model;

public class UserResults {
    private UserName name;
    private UserDob dob;
    private UserPicture picture;

    public UserResults() {
    }

    public UserResults(UserName name, UserDob dob, UserPicture picture) {
        this.name = name;
        this.dob = dob;
        this.picture = picture;
    }

    public UserName getName() {
        return name;
    }

    public void setName(UserName name) {
        this.name = name;
    }

    public UserDob getDob() {
        return dob;
    }

    public void setDob(UserDob dob) {
        this.dob = dob;
    }

    public UserPicture getPicture() {
        return picture;
    }

    public void setPicture(UserPicture picture) {
        this.picture = picture;
    }
}

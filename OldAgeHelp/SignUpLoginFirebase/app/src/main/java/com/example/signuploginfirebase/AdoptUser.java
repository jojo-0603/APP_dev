package com.example.signuploginfirebase;

public class AdoptUser {

    String firstname,lastName,age,hobby,address;

    public AdoptUser() {
    }

    public AdoptUser(String firstName, String lastName, String age, String hobby, String address) {
        this.firstname = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hobby = hobby;
        this.address = address;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getHobby() {
        return hobby;
    }

    public String getAddress() {
        return address;
    }
}

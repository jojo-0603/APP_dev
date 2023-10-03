package com.example.signuploginfirebase;

import com.google.android.material.textfield.TextInputLayout;

public class adoptdata{
    String a_firstname,a_lastname,a_age,a_hobby,a_address;

    public adoptdata(String a_firstname, String a_lastname, String a_age, String a_hobby, String a_address) {
        this.a_firstname = a_firstname;
        this.a_lastname = a_lastname;
        this.a_age = a_age;
        this.a_hobby = a_hobby;
        this.a_address = a_address;
    }

    public String getA_firstname() {
        return a_firstname;
    }

    public void setA_firstname(String a_firstname) {
        this.a_firstname = a_firstname;
    }

    public String getA_lastname() {
        return a_lastname;
    }

    public void setA_lastname(String a_lastname) {
        this.a_lastname = a_lastname;
    }

    public String getA_age() {
        return a_age;
    }

    public void setA_age(String a_age) {
        this.a_age = a_age;
    }

    public String getA_hobby() {
        return a_hobby;
    }

    public void setA_hobby(String a_hobby) {
        this.a_hobby = a_hobby;
    }

    public String getA_address() {
        return a_address;
    }

    public void setA_address(String a_address) {
        this.a_address = a_address;
    }
}

package com.example.bhaago;

public class Helper {
    String name,height,weight,email,password;

    public Helper(String name,String height,String weight,String email,String password) {
        this.name = name;
        this.email=email;
        this.height=height;
        this.weight=weight;
        this.password=password;
    }

    public Helper() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

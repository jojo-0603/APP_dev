package com.example.signuploginfirebase;

public class donatedata {
    String d_name,d_email,d_number,d_add,type,quantity;

    public donatedata() {
    }

    public donatedata(String d_name, String d_email, String d_number, String d_add, String type, String quantity) {
        this.d_name = d_name;
        this.d_email = d_email;
        this.d_number = d_number;
        this.d_add = d_add;
        this.type = type;
        this.quantity = quantity;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_email() {
        return d_email;
    }

    public void setD_email(String d_email) {
        this.d_email = d_email;
    }

    public String getD_number() {
        return d_number;
    }

    public void setD_number(String d_number) {
        this.d_number = d_number;
    }

    public String getD_add() {
        return d_add;
    }

    public void setD_add(String d_add) {
        this.d_add = d_add;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

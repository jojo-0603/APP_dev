package com.example.signuploginfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DonateFood extends AppCompatActivity {

    TextInputLayout d_name, d_email, d_phone, d_add, type, quantity;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donatefood);

        d_name = findViewById(R.id.donor_name);
        d_email = findViewById(R.id.donor_email_id);
        d_phone = findViewById(R.id.donor_phone);
        d_add = findViewById(R.id.donor_address);
        type = findViewById(R.id.food_type);
        quantity = findViewById(R.id.food_quantity);
    }

    public void sharebutton(View view) {
        String fullname_ = d_name.getEditText().getText().toString();
        String email_ = d_email.getEditText().getText().toString();
        String number_ = d_phone.getEditText().getText().toString();
        String address_ = d_add.getEditText().getText().toString();
        String foodtype_ = type.getEditText().getText().toString();
        String quantity_ = quantity.getEditText().getText().toString();

        if (!fullname_.isEmpty()) {
            d_name.setError(null);
            d_name.setErrorEnabled(false);
            if (!email_.isEmpty()) {
                d_email.setError(null);
                d_email.setErrorEnabled(false);
                if (!number_.isEmpty()) {
                    d_phone.setError(null);
                    d_phone.setErrorEnabled(false);
                    if (!address_.isEmpty()) {
                        d_add.setError(null);
                        d_add.setErrorEnabled(false);
                        if (!foodtype_.isEmpty()) {
                            type.setError(null);
                            type.setErrorEnabled(false);
                            if (!quantity_.isEmpty()) {
                                quantity.setError(null);
                                quantity.setErrorEnabled(false);
                                if (email_.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                                    firebaseDatabase = FirebaseDatabase.getInstance();
                                    reference = firebaseDatabase.getReference("item");
                                    String fullname_s = d_name.getEditText().getText().toString();
                                    String email_s = d_email.getEditText().getText().toString();
                                    String number_s = d_phone.getEditText().getText().toString();
                                    String address_s = d_add.getEditText().getText().toString();
                                    String foodtype_s = type.getEditText().getText().toString();
                                    String quantity_s = quantity.getEditText().getText().toString();

                                    donatedata donatedatass = new donatedata(fullname_s, email_s, number_s, address_s, foodtype_s, quantity_s);
                                    reference.child(fullname_s).setValue(donatedatass);
                                    Toast.makeText(getApplicationContext(), "Shared Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), FoodPage_donor.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    d_email.setError("please enter a valid id");
                                }
                            } else {
                                quantity.setError("please enter a quantity");
                            }
                        } else {
                            type.setError("enter a foodtype");
                        }
                    } else {
                        d_add.setError("please enter an address");
                    }
                } else {
                    d_phone.setError("please enter a phone number ");
                }
            } else {
                d_email.setError("plearse enter an email id");
            }
        } else {
            d_name.setError("please enter a name");
        }
    }
}
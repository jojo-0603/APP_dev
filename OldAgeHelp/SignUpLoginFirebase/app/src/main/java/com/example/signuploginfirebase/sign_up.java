package com.example.signuploginfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.ref.Reference;

import kotlin.text.Regex;

public class sign_up extends AppCompatActivity {
    TextInputLayout fullname_var, username_var, email_var, phone_var, password_var;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sign_up);



        fullname_var = findViewById(R.id.name_input_field);
        username_var = findViewById(R.id.username_input_field);
        email_var = findViewById(R.id.email_input_field);
        phone_var = findViewById(R.id.Phone_input_field);
        password_var = findViewById(R.id.password_field);


    }

    public void registerbuttonclick(View view) {
        String fullname_ = fullname_var.getEditText().getText().toString();
        String username_ = username_var.getEditText().getText().toString();
        String email_ = email_var.getEditText().getText().toString();
        String phonenumber_ = phone_var.getEditText().getText().toString();
        String password_ = password_var.getEditText().getText().toString();

        if (!fullname_.isEmpty()) {
            fullname_var.setError(null);
            fullname_var.setErrorEnabled(false);
            if (!username_.isEmpty()) {
                username_var.setError(null);
                username_var.setErrorEnabled(false);
                if (!email_.isEmpty()) {
                    email_var.setError(null);
                    email_var.setErrorEnabled(false);
                    if (!phonenumber_.isEmpty()) {
                        phone_var.setError(null);
                        phone_var.setErrorEnabled(false);
                        if (!password_.isEmpty()) {
                            password_var.setError(null);
                            password_var.setErrorEnabled(false);
                            if(email_.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
                            firebaseDatabase=FirebaseDatabase.getInstance();
                            reference=firebaseDatabase.getReference("datauser");
                                String fullname_s= fullname_var.getEditText().getText().toString();
                                String username_s= username_var.getEditText().getText().toString();
                                String email_s= email_var.getEditText().getText().toString();
                                String phonenumber_s= phone_var.getEditText().getText().toString();
                                String password_s= password_var.getEditText().getText().toString();

                                storingdata storingdatass=new storingdata(fullname_s,username_s,email_s,phonenumber_s,password_s);
                                reference.child(username_s).setValue(storingdatass);
                                Toast.makeText(getApplicationContext(),"Registration Successfull",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),login.class);
                                startActivity(intent);
                                finish();


                            }else{
                                email_var.setError("invalid email");
                            }
                        } else {
                            password_var.setError("please enter a password");
                        }
                    } else {
                        phone_var.setError("please enter a phone number");
                    }
                } else {
                    email_var.setError("enter an email id");
                }
            } else {
                username_var.setError("please enter a password");
            }
        } else {
            fullname_var.setError("please enter username");
        }
    }

    public void loginbuttonclick(View view) {
        Intent intent = new Intent(getApplicationContext(), login.class);
        startActivity(intent);
    }
}

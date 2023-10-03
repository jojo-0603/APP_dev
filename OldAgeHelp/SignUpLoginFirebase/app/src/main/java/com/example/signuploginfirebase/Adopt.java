package com.example.signuploginfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Adopt extends AppCompatActivity {

    TextInputLayout FirstName,LastName,Age,Hobby,Address;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt);

        FirstName=findViewById(R.id.adopt_Fname);
        LastName=findViewById(R.id.adopt_Lname);
        Age=findViewById(R.id.adopt_age);
        Hobby=findViewById(R.id.adopt_hobby);
        Address=findViewById(R.id.adopt_address);

    }
    public void share(View view){
        String Fname=FirstName.getEditText().getText().toString();
        String Lname=LastName.getEditText().getText().toString();
        String age=Age.getEditText().getText().toString();
        String hobby=Hobby.getEditText().getText().toString();
        String address=Address.getEditText().getText().toString();

        if(!Fname.isEmpty()){
            FirstName.setError(null);
            FirstName.setErrorEnabled(false);
            if(!Lname.isEmpty()){
                LastName.setError(null);
                LastName.setErrorEnabled(false);
                if(!age.isEmpty()){
                    Age.setError(null);
                    Age.setErrorEnabled(false);
                    if(!hobby.isEmpty()){
                        Hobby.setError(null);
                        Hobby.setErrorEnabled(false);
                        if(!address.isEmpty()){
                            Address.setError(null);
                            Address.setErrorEnabled(false);
                            firebaseDatabase = FirebaseDatabase.getInstance();
                            reference = firebaseDatabase.getReference("AdoptUser");
                            String firstname_s = FirstName.getEditText().getText().toString();
                            String lastname_s = LastName.getEditText().getText().toString();
                            String age_s = Age.getEditText().getText().toString();
                            String hobby_s = Hobby.getEditText().getText().toString();
                            String address_s =Address.getEditText().getText().toString();

                            adoptdata adoptdatas = new adoptdata(firstname_s,lastname_s,age_s,hobby_s,address_s);
                            reference.child(firstname_s).setValue(adoptdatas);
                            Toast.makeText(getApplicationContext(), "Shared Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), adopt_receiver.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Address.setError("please enter an address");
                        }
                    } else {
                        Hobby.setError("please enter a hobby");
                    }
                } else {
                    Age.setError("enter a age");
                }
            } else {
                LastName.setError("please enter a last name");
            }
        } else {
            FirstName.setError("please enter a first name");
        }
    }
}
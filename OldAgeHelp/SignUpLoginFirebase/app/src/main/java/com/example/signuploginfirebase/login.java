package com.example.signuploginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    Button signupbutton,loginbtnR,loginbtnD;
    TextInputLayout username_var,password_var;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);


        signupbutton=findViewById(R.id.signup_button);
        loginbtnR=findViewById(R.id.login_buttonR);
        loginbtnD=findViewById(R.id.login_buttonD);
        username_var=findViewById(R.id.username_text_field_design);
        password_var=findViewById(R.id.password_input_field);

        loginbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_=username_var.getEditText().getText().toString();
                String password_=password_var.getEditText().getText().toString();

                if(!username_.isEmpty()){
                    username_var.setError(null);
                    username_var.setErrorEnabled(false);
                    if(!password_.isEmpty()){
                        password_var.setError(null);
                        password_var.setErrorEnabled(false);

                        final String username_data=username_var.getEditText().getText().toString();
                        final String password_data=password_var.getEditText().getText().toString();

                        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                        DatabaseReference databaseReference=firebaseDatabase.getReference("datauser");

                        Query check_username=databaseReference.orderByChild("username").equalTo(username_data);
                        check_username.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    username_var.setError(null);
                                    username_var.setErrorEnabled(false);
                                    String password_check=snapshot.child(username_data).child("password").getValue(String.class);
                                    if (password_data.equals(password_check)){
                                        password_var.setError(null);
                                        password_var.setErrorEnabled(false);
                                        Toast.makeText(getApplicationContext(),"login successfull",Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(getApplicationContext(), OptionPageDonorActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }else{
                                        password_var.setError("wrong password");
                                    }

                                }else{
                                    username_var.setError("user does not exists");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });




                    }else {
                        password_var.setError("please enter a password");
                    }
                }else {
                    username_var.setError("please enter username");
                }
            }
        });
        loginbtnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_=username_var.getEditText().getText().toString();
                String password_=password_var.getEditText().getText().toString();

                if(!username_.isEmpty()){
                    username_var.setError(null);
                    username_var.setErrorEnabled(false);
                    if(!password_.isEmpty()){
                    password_var.setError(null);
                    password_var.setErrorEnabled(false);

                    final String username_data=username_var.getEditText().getText().toString();
                    final String password_data=password_var.getEditText().getText().toString();

                    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference=firebaseDatabase.getReference("datauser");

                    Query check_username=databaseReference.orderByChild("username").equalTo(username_data);
                    check_username.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                username_var.setError(null);
                                username_var.setErrorEnabled(false);
                                String password_check=snapshot.child(username_data).child("password").getValue(String.class);
                                if (password_data.equals(password_check)){
                                    password_var.setError(null);
                                    password_var.setErrorEnabled(false);
                                    Toast.makeText(getApplicationContext(),"login successfull",Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(), options_page_receiver.class);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    password_var.setError("wrong password");
                                }

                            }else{
                                username_var.setError("user does not exists");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });




                    }else {
                        password_var.setError("please enter a password");
                    }
                }else {
                    username_var.setError("please enter username");
                }
            }
        });


        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), sign_up.class);
                startActivity(intent);

            }
        });
    }
}
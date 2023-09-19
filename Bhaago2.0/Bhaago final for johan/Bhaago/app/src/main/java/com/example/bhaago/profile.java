package com.example.bhaago;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class profile extends AppCompatActivity {

    TextInputLayout fullName,email,height,weight;
   Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_profile);

        fullName = findViewById(R.id.full_name_profile);
        email = findViewById(R.id.email_profile);
        height = findViewById(R.id.height_profile);
        weight = findViewById(R.id.weight_profile);
        bt=findViewById (R.id.home);

        showAllUserData();
        bt.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent in=new Intent (profile.this,HomePage.class);
                startActivity (in);
            }
        });
    }

    private void showAllUserData() {

//        Intent intent =getIntent();
//        String user_name=intent.getStringExtra("name");
//        String user_email=intent.getStringExtra("email");
//        String user_height=intent.getStringExtra("height");
//        String user_weight=intent.getStringExtra("weight");

        SharedPreferences shrd=getSharedPreferences("profile",MODE_PRIVATE);
        String user_name= shrd.getString("name","Empty");
        String user_email= shrd.getString("email","Empty");
        String user_height= shrd.getString("height","Empty");
        String user_weight=shrd.getString("weight","Empty");

        fullName.getEditText().setText(user_name);
        email.getEditText().setText(user_email);
        height.getEditText().setText(user_height);
        weight.getEditText().setText(user_weight);


    }
}





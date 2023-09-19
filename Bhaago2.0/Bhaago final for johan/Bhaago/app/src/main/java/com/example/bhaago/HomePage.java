package com.example.bhaago;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity {
    ImageButton iv;
    Button button2,button1,button3;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_home_page);
        button = findViewById (R.id.button);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);



        iv=findViewById (R.id.imageButton);


        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent (HomePage.this,Kotlin1.class);
                startActivity (inten);
            }
        });


        button1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent inten1 = new Intent (HomePage.this,BarGraph.class);
                startActivity (inten1);
            }
        });


        button2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
//                Intent inten2 =new Intent (HomePage.this,BarGraph.class);
//                startActivity (inten2);
            }
        });

        button3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
               Intent inten3 =new Intent (HomePage.this,links.class);
               startActivity (inten3);
            }
        });

        iv.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent inten4 =new Intent (HomePage.this,profile.class);
                startActivity (inten4);
            }
        });

    }
}
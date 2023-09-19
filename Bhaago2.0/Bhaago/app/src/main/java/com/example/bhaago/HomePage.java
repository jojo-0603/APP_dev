package com.example.bhaago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomePage extends AppCompatActivity {
ImageButton iv;
    Button button2;
    Button button;
    FloatingActionButton fmain,fplus,fplus2;
    Float transY = 100f;
    Boolean menu=false;
    OvershootInterpolator interpolator = new OvershootInterpolator ();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_home_page);
         button = findViewById (R.id.button);
         button2=findViewById (R.id.button3);

        iv=findViewById (R.id.imageButton);
        fmain=findViewById (R.id.UP_Button);
        fplus =findViewById (R.id.Extra_button);
        fplus2=findViewById (R.id.Extra2_button);



        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent (HomePage.this,Pedo.class);
                startActivity (inten);
            }
        });
        button2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent inten1 =new Intent (HomePage.this,BarGraph.class);
                startActivity (inten1);
            }
        });
        iv.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent inten2 =new Intent (HomePage.this,profile.class);
                startActivity (inten2);
            }
        });
        fplus.setAlpha (0f);
        fplus2.setAlpha (0f);
        fplus.setTranslationY (transY);
        fplus2.setTranslationY (transY);

        fmain.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (menu){
                    CloseMenu();
                }
                else {
                    OpenMenu();
                }
            }
        });
        fplus.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (HomePage.this,"first one is clicked",Toast.LENGTH_SHORT).show ();
                Intent inten2 =new Intent (HomePage.this,MapsAct.class);
                startActivity (inten2);
            }
        });
        fplus2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (HomePage.this,"second one is clicked",Toast.LENGTH_SHORT).show ();

            }
        });

    }
    private void OpenMenu() {
        menu = !menu;
        fmain.setImageResource(R.drawable.sharp_expand_more_24);
        fplus.animate ().translationY (0f).alpha (1f).setInterpolator (interpolator).setDuration (300).start ();
        fplus2.animate ().translationY (0f).alpha (1f).setInterpolator (interpolator).setDuration (300).start ();

    }

    private void CloseMenu() {
        menu = !menu;
        fmain.setImageResource(R.drawable.sharp_expand_less_24);
        fplus.animate ().translationY (transY).alpha (0f).setInterpolator (interpolator).setDuration (300).start ();
        fplus2.animate ().translationY (transY).alpha (0f).setInterpolator (interpolator).setDuration (300).start ();


}}
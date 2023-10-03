package com.example.signuploginfirebase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class options_page_receiver extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_page_receiever);
        findViewById(R.id.food).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), FoodPage_receiver.class);
                startActivity(intent);
                finish();


            }


        });
        findViewById(R.id.adopt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Adopt.class);
                startActivity(intent);
                finish();


            }


        });
        findViewById(R.id.money).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),RazorPay.class);
                startActivity(intent);
                finish();

            }
        });
        findViewById(R.id.btnLogoutR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(options_page_receiver.this);

                // Set the message show for the Alert time
                builder.setMessage(Html.fromHtml("<font color='#FF7F27'>Do you want to Logout?</font>"));

                // Set Alert Title
                builder.setTitle("Alert !");

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(true);

                // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // When the user click yes button then app will close
                    Toast.makeText(options_page_receiver.this, "Signing out...", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(options_page_receiver.this,login.class);
                    startActivity(intent);
                    finish();
                });
                // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // If user click no then dialog box is canceled.
                    dialog.cancel();
                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                Button nbutton =alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                //Set negative button background
                nbutton.setBackgroundColor(Color.YELLOW);
                //Set negative button text color
                nbutton.setTextColor(Color.BLACK);
                Button pbutton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
                //Set positive button background
                pbutton.setBackgroundColor(Color.RED);
                //Set positive button text color
                pbutton.setTextColor(Color.WHITE);
                // Show the Alert Dialog box
          }
        });





            }
}
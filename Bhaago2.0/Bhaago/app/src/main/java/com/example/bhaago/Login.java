package com.example.bhaago;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaCodec;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.intellij.lang.annotations.Pattern;

import java.util.Objects;

public class Login extends AppCompatActivity {


    Button forgotPass,newUser,login;
    TextView chalo,welcome;
    FirebaseAuth auth;
    TextInputLayout username,pass;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        getWindow ().setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_main);
        Button callsignup;
        auth=FirebaseAuth.getInstance ();

        callsignup=findViewById (R.id.newuser);
        callsignup.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Login.this,HomePage.class);
                startActivity (intent);

            }
        });
        login=findViewById (R.id.Login);
        login.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                isUser ();

            }
        });
        forgotPass=findViewById (R.id.forgotpass);

        forgotPass.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder (Login.this);
                View dialogView = getLayoutInflater ().inflate (R.layout.dialogue_forgot, null);
                EditText emailBox = dialogView.findViewById (R.id.emailBox);

                builder.setView (dialogView);
                AlertDialog dialog = builder.create ();

                dialogView.findViewById (R.id.btnReset).setOnClickListener (new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        String email = emailBox.getText ().toString ();
                        if (TextUtils.isEmpty (email) && !Patterns.EMAIL_ADDRESS.matcher (email).matches () ){
                            Toast.makeText (Login.this, "Please enter the registered email", Toast.LENGTH_SHORT).show ();
                            emailBox.setError ("Email is Required");
                            emailBox.requestFocus ();
                            return;
                        }else {
                            auth.sendPasswordResetEmail (email).addOnCompleteListener (new OnCompleteListener<Void> () {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful ()) {
                                        Toast.makeText (Login.this, "Please check your inbox", Toast.LENGTH_SHORT).show ();
                                        dialog.dismiss ();
                                    } else {
                                        Toast.makeText (Login.this, " Unable to send ", Toast.LENGTH_SHORT).show ();
                                    }
                                }
                            });
                        }

                    }



                });
                dialogView.findViewById (R.id.btncancel).setOnClickListener (new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss ();
                    }
                });
                if(dialog.getWindow ()!=null){
                    dialog.getWindow ().setBackgroundDrawable (new ColorDrawable (0));
                }
                dialog.show ();

            }
            });


    }


    private void isUser() {


       username=findViewById (R.id.username);
       pass=findViewById (R.id.password);

        String userEnterValues= Objects.requireNonNull (username.getEditText ()).getText ().toString ().trim ();
        String userEnteredPass= Objects.requireNonNull (pass.getEditText ()).getText ().toString ().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ("data");

        Query checkUser = reference.orderByChild ("name").equalTo (userEnterValues);

        checkUser.addListenerForSingleValueEvent (new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
              if(snapshot.exists ()){
                  username.setError (null);
                  username.setErrorEnabled (false);

                  String passwordFromDb=snapshot.child (userEnterValues).child ("password").getValue (String.class);
                  assert passwordFromDb != null;
                  if(passwordFromDb.equals (userEnteredPass)){
                      username.setError (null);
                      username.setErrorEnabled (false);
                      String nameFromDb=snapshot.child (userEnterValues).child ("name").getValue (String.class);
                      String heightFromDb=snapshot.child (userEnterValues).child ("height").getValue (String.class);
                      String weightFromDb=snapshot.child (userEnterValues).child ("weight").getValue (String.class);
                      String emailFromDb=snapshot.child (userEnterValues).child ("email").getValue (String.class);


                      Intent intent =new Intent (getApplicationContext (),profile.class);
                      intent.putExtra ("name",nameFromDb);
                      intent.putExtra ("height",heightFromDb);
                      intent.putExtra ("weight",weightFromDb);
                      intent.putExtra ("email",emailFromDb);
                      intent.putExtra ("password",passwordFromDb);

                      startActivity (intent);
                  }
                  else {
                      pass.setError ("Wrong Password");
                  }
              }
              else{
                  username.setError ("No Such User Exists");
                  username.requestFocus ();
              }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
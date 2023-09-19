package com.example.bhaago;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignIn extends AppCompatActivity {
    TextInputLayout regName,regHeight,regWeight,regEmail,regPassword;
    Button regSignin,regLogin;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        getWindow ().setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_sign_in);


        regName=findViewById (R.id.name);
        regHeight=findViewById (R.id.height);
        regWeight=findViewById (R.id.weight);
        regEmail=findViewById (R.id.email);
        regPassword=findViewById (R.id.password);
        regSignin=findViewById (R.id.SignIn);
        regLogin=findViewById (R.id.Login);

        regSignin.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if(!validateName () || !validateHeight () || !validateWeight () ||!validateEmail () || !validatePassword ()){
                    return;
                }
                rootNode=FirebaseDatabase.getInstance ();
                reference = rootNode.getReference ("data");
                String name = Objects.requireNonNull (regName.getEditText ()).getText ().toString ();
                String height = Objects.requireNonNull (regHeight.getEditText ()).getText ().toString ();
                String weight = Objects.requireNonNull (regWeight.getEditText ()).getText ().toString ();
                String email = Objects.requireNonNull (regEmail.getEditText ()).getText ().toString ();
                String pass = Objects.requireNonNull (regPassword.getEditText ()).getText ().toString ();

                Helper help=new Helper (name,height,weight,email,pass);

                reference.child (name).setValue (help);
                Intent intent =new Intent (SignIn.this,HomePage.class);
                startActivity (intent);
            }
        });



regLogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent int1 = new Intent(SignIn.this,Login.class);
        startActivity(int1);
    }
});
    }

    private Boolean validateWeight(){
        String val = regWeight.getEditText().getText().toString();

        if (val.isEmpty()) {
            regWeight.setError("Field cannot be empty");
            return false;
        } else {
            regWeight.setError(null);
            regWeight.setErrorEnabled (false);
            return true;
        }
    }
    private Boolean validateName(){
        String val = regName.getEditText().getText().toString();

        if (val.isEmpty()) {
            regName.setError("Field cannot be empty");
            return false;

        } else if (val.length ()>=15) {
            regName.setError ("Name Too Long");
            return false;
            
        } else {
            regName.setError(null);
            regName.setErrorEnabled (false);
            return true;
        }
    }
    private Boolean validateHeight(){
        String val = regHeight.getEditText().getText().toString();

        if (val.isEmpty()) {
            regHeight.setError("Field cannot be empty");
            return false;
        } else {
            regHeight.setError(null);
            regHeight.setErrorEnabled (false);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val = regPassword.getEditText().getText().toString();

        if (val.isEmpty()) {
            regPassword.setError("Field cannot be empty");
            return false;
        } else {
            regPassword.setError(null);
            regPassword.setErrorEnabled (false);
            return true;
        }
    }

    public Boolean validateEmail() {
        String val =  (regEmail.getEditText ()).getText().toString();
        String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";


        if (val.isEmpty()) {
            regEmail.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            regEmail.setError("Invalid email address");
            return false;
        }else{
            regEmail.setError(null);
            return true;
        }
    }
    public void registerUser(View view) {
        String email = regEmail.getEditText().getText ().toString();
        String name = regName.getEditText().getText ().toString();
        String weight = regWeight.getEditText().getText ().toString();
        String height = regHeight.getEditText().getText ().toString();

        String pass = regPassword.getEditText().getText ().toString();
        Helper helper= new Helper (name,email,weight,height,pass);
        reference.child (name).setValue (helper);



    }


}

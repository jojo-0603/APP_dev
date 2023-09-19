package com.example.bhaago;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate (savedInstanceState, persistentState);
        setContentView (R.layout.activity_profile);
        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                FirebaseMessaging.getInstance ().subscribeToTopic ("Mess").addOnCompleteListener (new OnCompleteListener<Void> () {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg="Done";
                        if(!task.isSuccessful ()){
                            msg="Failed";
                        }
                    }
                });
            }
        });

    }
}

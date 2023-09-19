package com.example.bhaago;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Pedo extends AppCompatActivity implements SensorEventListener {

    private TextView textViewStepCounter;
    EditText cal,dist;
    private SensorManager sensorManager;
    private Sensor mStepCounter;
    public boolean isCounterSensorPresent;
    int stepCount = 0 ;
    float calories,distance;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedo);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            progressBar=findViewById (R.id.progress_bar);
        }
        findViewById (R.id.progress_text);


        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACTIVITY_RECOGNITION)== PackageManager.PERMISSION_DENIED)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION},0);
                }
            }
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        textViewStepCounter = findViewById(R.id.progress_text) ;
        cal=findViewById(R.id.editTextTextPersonName4);
        dist= findViewById(R.id.editTextTextPersonName3);


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) !=null)
        {
            mStepCounter = sensorManager.getDefaultSensor (Sensor.TYPE_STEP_COUNTER);
            isCounterSensorPresent = true;
        }


    }



    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor == mStepCounter){
            stepCount = (int) sensorEvent.values[0];
            distance=0.7f*stepCount;
            calories=0.05f*stepCount;
            textViewStepCounter.setText(String.valueOf(stepCount));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                progressBar.setProgress (stepCount);
            }
            cal.setText(String.valueOf(calories));
            dist.setText(String.valueOf(distance));
        }
    }



    @Override
    public void onAccuracyChanged (Sensor sensor,int i)
    {
    }



    @Override
    protected void onResume() {
        super.onResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!= null)
            sensorManager.registerListener(this,mStepCounter,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause ();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) !=null)
            sensorManager.unregisterListener(this,mStepCounter);
    }
}
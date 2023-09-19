package com.example.bhaago

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import java.text.SimpleDateFormat
import java.util.*

class Kotlin1 : AppCompatActivity(), SensorEventListener {

    private  var sensorManager: SensorManager?=null
    private var running =false
    private var totalSteps=0f
    private var previousTotalSteps=0f

    var calories = 0f
    var distance = 0f
    private var stepsMon =8253f
    private var stepsTues =7689f
    private var stepsWed =9045f
    private var stepsThrus =5590f
    private var stepsFri =0f
    private var stepsSat =0f
    private var stepsSun =0f
    private var copy="Day"
    var button: Button? = null

    var cal: EditText? = null
    var dist:EditText? = null

    private val circularProgressBar: CircularProgressBar
        get() = findViewById(R.id.progress_circular)
    private val stepsTaken: TextView
        get() = findViewById(R.id.tv_stepsTaken)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin1)

        cal = findViewById(R.id.editTextTextPersonName4)
        dist = findViewById(R.id.editTextTextPersonName3)

        val calendar = Calendar.getInstance()
        val dayFormat = SimpleDateFormat("EEEE")
        val dayOfWeek = dayFormat.format(calendar.time)
        copy=dayOfWeek

//        button = findViewById(R.id.button)

        loadData()
        resetSteps()
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

//        button?.setOnClickListener(View.OnClickListener {
//            val intent = Intent(this, BarGraph::class.java)
//            startActivity(intent)
//        })

    }

    override fun onResume() {
        super.onResume()
        running=true
        val stepSensor: Sensor?=sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepSensor==null)
        { Toast.makeText(this,"No sensor", Toast.LENGTH_SHORT).show()
        }
        else
        { sensorManager?.registerListener(this,stepSensor, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (running){
            val sharedPreference=getSharedPreferences("graph", Context.MODE_PRIVATE)
            val  editor=sharedPreference.edit()

            totalSteps=event!!.values[0]
            val currentSteps =totalSteps.toInt()-previousTotalSteps.toInt()
            stepsTaken.text=("$currentSteps")

            when (copy) {
                "Monday" -> {stepsMon=currentSteps.toFloat()}
                "Tuesday" -> {stepsTues=currentSteps.toFloat()}
                "Wednesday" -> {stepsWed=currentSteps.toFloat()}
                "Thursday" -> {stepsThrus=currentSteps.toFloat()}
                "Friday" -> {stepsFri=totalSteps.toFloat()}
                "Saturday" -> {stepsSat=currentSteps.toFloat()}
                "Sunday" -> {stepsSun=currentSteps.toFloat()}
            }
//            println("My float value is: $stepsThrus")


            circularProgressBar.apply{
                setProgressWithAnimation(currentSteps.toFloat())
            }

            editor.putFloat("mon",stepsMon)
            editor.putFloat("tues",stepsTues)
            editor.putFloat("wed",stepsWed)
            editor.putFloat("thrus",stepsThrus)
            editor.putFloat("fri",stepsFri)
            editor.putFloat("sat",stepsSat)
            editor.putFloat("sun",stepsSun)
            editor.apply()

            distance = 0.7f * currentSteps
            calories = 0.05f * currentSteps

            cal!!.setText(calories.toString())
            dist!!.setText(distance.toString())

        }
    }

    fun resetSteps(){
        stepsTaken.setOnClickListener{
            Toast.makeText(this,"Long tap to reset steps", Toast.LENGTH_SHORT).show()
        }

        stepsTaken.setOnLongClickListener{

            previousTotalSteps=totalSteps
            stepsTaken.text=0.toString()
            saveData()

            true
        }

    }

    private  fun saveData(){
        val sharedPreferences=getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        editor.putFloat("key1",previousTotalSteps)
        editor.apply()
    }

    private fun loadData(){
        val sharedPreferences=getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val savedNumber = sharedPreferences.getFloat("key1",0f)
        Log.d("MainActivity","$savedNumber")
        previousTotalSteps = savedNumber


    }
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}
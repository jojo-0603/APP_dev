package com.example.bhaago;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class BarGraph extends AppCompatActivity {



    BarChart barChart;
    private TextView textView;
    Float stepsMon;
    Float stepsTues;
    Float stepsWed;
    Float stepsThrus;
    Float stepsFri;
    Float stepsSat;
    Float stepsSun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);

        SharedPreferences sharedPreference=getSharedPreferences("graph",MODE_PRIVATE);
        stepsMon= sharedPreference.getFloat("mon",10f);
        stepsTues= sharedPreference.getFloat("tues",20f);
        stepsWed= sharedPreference.getFloat("wed",30f);
        stepsThrus= sharedPreference.getFloat("thrus",40f);
        stepsFri= sharedPreference.getFloat("fri",50f);
        stepsSat= sharedPreference.getFloat("sat",0f);
        stepsSun= sharedPreference.getFloat("sun",0f);

        barChart=findViewById(R.id.mp_BarChart);
        BarDataSet barDataSet1=new BarDataSet(dataValues1(),"dataset1");
        BarData barData=new BarData();
        barData.addDataSet(barDataSet1);

        // Set labels for each day
        ArrayList<String> labels = new ArrayList<>();
        labels.add("Mon");
        labels.add("Tue");
        labels.add("Wed");
        labels.add("Thu");
        labels.add("Fri");
        labels.add("Sat");
        labels.add("Sun");

        // Set X-axis value formatter to use the labels
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);

        barChart.setDrawGridBackground(true);
        barChart.setDrawBorders(true);
        barChart.setBorderWidth(2);

        barChart.setData(barData);
        barChart.invalidate();
    }

    private ArrayList<BarEntry> dataValues1(){
        ArrayList<BarEntry> dataVals=new ArrayList<>();
        dataVals.add(new BarEntry(0,stepsMon));
        dataVals.add(new BarEntry(1,stepsTues));
        dataVals.add(new BarEntry(2,stepsWed));
        dataVals.add(new BarEntry(3,stepsThrus));
        dataVals.add(new BarEntry(4,stepsFri));
        dataVals.add(new BarEntry(5,stepsSat));
        dataVals.add(new BarEntry(6,stepsSun));
        return dataVals;
    }
}
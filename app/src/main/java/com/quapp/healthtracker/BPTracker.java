package com.quapp.healthtracker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BPTracker extends AppCompatActivity {

    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bp_tracker);

        barChart = findViewById(R.id.barChart);

        BarDataSet barDataSet = new BarDataSet(barChartDataSet(),"Blood Pressure");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(R.color.colorAccent);
        barDataSet.setValueTextSize(14f);
        BarData barData = new BarData(barDataSet);
        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Weekly Blood Presure Data");
        barChart.animateY(2000);

    }

    private ArrayList<BarEntry> barChartDataSet(){
        ArrayList<BarEntry> data = new ArrayList<>();

        data.add(new BarEntry(1,120));
        data.add(new BarEntry(2,130));
        data.add(new BarEntry(3,90));
        data.add(new BarEntry(4,60));
        data.add(new BarEntry(5,100));
        data.add(new BarEntry(6,60));
        data.add(new BarEntry(7,130));
        data.add(new BarEntry(8,110));
        data.add(new BarEntry(9,90));
        data.add(new BarEntry(10,105));
        return  data;


    }
}

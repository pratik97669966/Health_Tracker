package com.quapp.healthtracker;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class WeightTracker extends AppCompatActivity {

    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_tracker);

        lineChart = findViewById(R.id.lineChart);
        LineDataSet lineDataSet = new LineDataSet(lineChartDataSet(), "Monthly Weight");
        ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
        iLineDataSets.add(lineDataSet);

        LineData lineData = new LineData(iLineDataSets);
        lineChart.setData(lineData);
        lineChart.invalidate();
        //bg
        // lineChart.setBackgroundColor(Color.RED);
        //upper limit
        LimitLine upper_limit = new LimitLine(80f, "High Weight");
        upper_limit.setLineWidth(4f);
        upper_limit.enableDashedLine(10f, 10f, 10f);
        upper_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        upper_limit.setTextSize(15f);
        //lower imit
        LimitLine lower_limit = new LimitLine(38f, "low Weight");
        lower_limit.setLineWidth(4f);
        lower_limit.enableDashedLine(10f, 10f, 10f);
        lower_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        lower_limit.setTextSize(15f);
//set limit to y axis dotted line
        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.addLimitLine(upper_limit);
        leftAxis.addLimitLine(lower_limit);
        leftAxis.setAxisMaximum(100f);
        leftAxis.setAxisMinimum(25f);
        leftAxis.enableGridDashedLine(10f, 10f, 0);
        leftAxis.setDrawLimitLinesBehindData(true);

        // set text if data are not available
        lineChart.setNoDataText("Data not Available");
        lineDataSet.setColor(Color.BLUE);
        lineDataSet.setCircleColor(Color.GREEN);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setLineWidth(5);
        lineDataSet.setCircleRadius(2);
        lineDataSet.setCircleHoleRadius(10);
        lineDataSet.setValueTextSize(10);
        lineDataSet.setValueTextColor(Color.BLACK);

        //right visibility false
        lineChart.getAxisRight().setEnabled(false);

        String[] values = new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new myXAxisValueFormater(values));
       // xAxis.setGranularity(1f);
    }

public  class myXAxisValueFormater extends ValueFormatter implements IAxisValueFormatter{
        private  String[] mValues;
        public myXAxisValueFormater(String[] values){
            this.mValues =values;
        }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
      return  mValues[(int) value];
    }
}
    private ArrayList<Entry> lineChartDataSet() {
        ArrayList<Entry> dataSet = new ArrayList<Entry>();

        dataSet.add(new Entry(0, 40));
        dataSet.add(new Entry(1, 38));
        dataSet.add(new Entry(2, 36));
        dataSet.add(new Entry(3, 35));
        dataSet.add(new Entry(4, 36));
        dataSet.add(new Entry(5, 43));
        dataSet.add(new Entry(6, 51));
        dataSet.add(new Entry(7, 58));
        dataSet.add(new Entry(8, 64));
        dataSet.add(new Entry(9, 78));
        dataSet.add(new Entry(10, 85));
        dataSet.add(new Entry(11, 89));
        dataSet.add(new Entry(12, 92));
        return dataSet;


    }
}

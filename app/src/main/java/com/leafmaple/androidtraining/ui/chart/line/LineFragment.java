package com.leafmaple.androidtraining.ui.chart.line;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.leafmaple.androidtraining.R;
import com.leafmaple.androidtraining.base.BaseFragment2;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class LineFragment extends BaseFragment2 {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_line, container, false);
        LineChart chart = root.findViewById(R.id.lineChart);
        LineViewModel lineViewModel = new ViewModelProvider(this).get(LineViewModel.class);
        lineViewModel.getLineList().observe(getViewLifecycleOwner(),lineBeans -> {
            List<Entry> entries = new ArrayList<Entry>();
            for (int i = 0; i < lineBeans.size(); i++) {
                entries.add(new Entry(i,lineBeans.get(i).getSalaries()));
            }

            LineDataSet dataSet = new LineDataSet(entries, "工资"); // add entries to dataset
            dataSet.setColor(Color.BLUE);
            dataSet.setValueTextColor(Color.RED); // styling, ...
            dataSet.setValueTextSize(12f);
            dataSet.setLineWidth(6f);

            LineData lineData = new LineData(dataSet);
            chart.setData(lineData);
            chart.invalidate(); // refresh

            XAxis xAxis = chart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

            xAxis.setTextColor(Color.BLACK);
            xAxis.setAxisLineColor(Color.BLACK);
            xAxis.setAxisLineWidth(3f);
            xAxis.enableGridDashedLine(10f,10f,0f);
// set a custom value formatter
            xAxis.setValueFormatter(new ValueFormatter() {
                @Override
                public String getFormattedValue(float value) {
                    //显示字符串
                    return lineBeans.get((int) value).getYear();
                }
            });

            chart.getAxisRight().setEnabled(false);
            YAxis yAxis = chart.getAxisLeft();

            yAxis.setAxisMinimum(0f); // start at zero
            yAxis.setSpaceTop(38.2f);
            yAxis.setTextColor(Color.BLACK);
            yAxis.setAxisLineColor(Color.BLACK);
            yAxis.setAxisLineWidth(3f);
            yAxis.enableGridDashedLine(10f,10f,0f);
            LimitLine line = new LimitLine(10000, "厦门市平均工资");


            line.setLineColor(Color.MAGENTA);
            line.setLineWidth(2f);
            yAxis.addLimitLine(line);
            Legend l = chart.getLegend();
            l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
            l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);

            Description description = chart.getDescription();
            description.setText("java工资");
            description.setTextAlign(Paint.Align.CENTER);
// set the position of the description on the screen
            description.setPosition(540f, 100f);
            description.setTextSize(16f);
            description.setTextColor(Color.BLACK);
            chart.animateX(5000);
//... and more
// and more...
        });
        return root;
    }

}
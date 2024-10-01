package com.example.rishi_2340_demo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

import com.example.rishi_2340_demo.BR;
import com.example.rishi_2340_demo.R;
import com.example.rishi_2340_demo.databinding.ActivityMainBinding;
import com.example.rishi_2340_demo.viewmodel.MainViewModel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //use data binding to inflate the layout
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.d(TAG, "onCreate called");

        //create viewModel
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        //bind viewmodel to layout
        binding.setVariable(BR.viewModel, viewModel);
        binding.setLifecycleOwner(this);
        //find button by id
        Button openButton = findViewById(R.id.text_button_open);

        //Set onClickListener
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create intent to start second activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);


                //Add extra data using bundles
                intent.putExtra("KEY", "Hello from Main Activity");

                //Start second activity

                startActivity(intent);
            }
        });

        Button countGraphButton = findViewById(R.id.increment_countergraph);
        countGraphButton.setOnClickListener((l) -> drawGraph(viewModel));
    }

    public void drawGraph(MainViewModel viewModel) {
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, viewModel.getCounter().getValue()));
        BarDataSet dataSet = new BarDataSet(entries, "Counter data");
        BarChart barChart = findViewById(R.id.barChart);
        barChart.setData(new BarData(dataSet));


        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setEnabled(false);
        barChart.getDescription().setEnabled(false);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawLabels(false);

        barChart.invalidate();


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }

}
package com.example.rishi_2340_demo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.util.Log;

import com.example.rishi_2340_demo.R;

public class SecondActivity extends AppCompatActivity {

    private final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate called");
        //Retrieve intent that started this activity

        Intent intent = getIntent();
        String message = intent.getStringExtra("KEY");

        //Find textView UI element by ID, then set text to the message provided below

        TextView textView = findViewById(R.id.text_second_activity);
        textView.setText(message);

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
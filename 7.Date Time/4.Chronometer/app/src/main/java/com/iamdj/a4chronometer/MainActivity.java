package com.iamdj.a4chronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Chronometer can be used to create stopwatch.
    Chronometer chronometer;
    Button buttonStart, buttonStop, buttonRestart;

    int pauseOffset = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.cm);
        buttonStart = findViewById(R.id.btn1);
        buttonStop = findViewById(R.id.btn2);
        buttonRestart = findViewById(R.id.btn3);

        buttonStop.setOnClickListener(this);
        buttonStart.setOnClickListener(this);
        buttonRestart.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(R.id.btn1 == view.getId()){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset); // used to start from same place where we pause.
            chronometer.start();
        }else if(R.id.btn2 == view.getId()){
            pauseOffset = (int) (SystemClock.elapsedRealtime() - chronometer.getBase()); // used to start from same place where we pause.
            chronometer.stop();
        }else if(R.id.btn3 == view.getId()){
            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseOffset = 0;
        }else
            finish(); // close app

    }
}
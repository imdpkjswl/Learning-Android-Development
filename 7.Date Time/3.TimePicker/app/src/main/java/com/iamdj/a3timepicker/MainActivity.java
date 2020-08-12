package com.iamdj.a3timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TimePicker.OnTimeChangedListener {

    TimePicker timePicker1, timePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker1 = findViewById(R.id.time1);
        timePicker2 = findViewById(R.id.time2);

        timePicker1.setOnTimeChangedListener(this);
        timePicker2.setOnTimeChangedListener(this);
    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int i1, int i2) {
        if(R.id.time1 == timePicker.getId()){
            Toast.makeText(getApplicationContext(), "Ring-Time: "+i1+":"+i2, Toast.LENGTH_SHORT).show();
        }

        if(R.id.time2 == timePicker.getId()){
            Toast.makeText(getApplicationContext(), "Spinner-Time: "+i1+":"+i2, Toast.LENGTH_SHORT).show();
        }
    }
}
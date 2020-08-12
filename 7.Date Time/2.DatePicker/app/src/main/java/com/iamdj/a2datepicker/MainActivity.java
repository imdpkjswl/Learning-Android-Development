package com.iamdj.a2datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener {

    DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.simpleDate);
        Calendar cal = Calendar.getInstance();
        datePicker.init(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH),this);

    }

    @Override
    public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
        Toast.makeText(this, "Date/Month/Year:  "+datePicker.getDayOfMonth()+
                "/"+(datePicker.getMonth()+1)+"/"+datePicker.getYear(), Toast.LENGTH_SHORT).show();
    }
}
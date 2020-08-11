package com.iamdj.a9spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spin);

        final ArrayList<String> course = new ArrayList<>();
        course.add("Java");
        course.add("Python");
        course.add("Machine Learning");
        course.add("HTML");
        course.add("CSS");
        course.add("JavaScript");
        course.add("MySql");
        course.add("Data Structures & Algorithms");
        course.add("Android");
        course.add("C/C++");
        course.add("Php");
        course.add("Github");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,course);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You selected: "+course.get(position), Toast.LENGTH_SHORT).show();

                // IMPORTANT : CUSTOM RESIZING AND COLORING SPINNER VALUES
                ((TextView) spinner.getChildAt(0)).setTextColor(Color.RED);
                ((TextView) spinner.getChildAt(0)).setTextSize(25);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }
}
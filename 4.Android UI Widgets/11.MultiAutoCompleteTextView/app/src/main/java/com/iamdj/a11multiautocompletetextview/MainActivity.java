package com.iamdj.a11multiautocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MultiAutoCompleteTextView multiAutoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multiAutoCompleteTextView = findViewById(R.id.mat);

        final ArrayList<String> name = new ArrayList<>();

        name.add("Deepak");
        name.add("Alan");
        name.add("Tony");
        name.add("Narendra Modi");
        name.add("David");
        name.add("alex");
        name.add("alevix");
        name.add("Vinay");
        name.add("Tanmay");
        name.add("Anish");
        name.add("Aashu");
        name.add("Erick");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,name);
        multiAutoCompleteTextView.setAdapter(adapter);
        // Separate strings by comma
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
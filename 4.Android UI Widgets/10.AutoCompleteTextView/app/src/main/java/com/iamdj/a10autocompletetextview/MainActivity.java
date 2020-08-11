package com.iamdj.a10autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.autoText);

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
        autoCompleteTextView.setAdapter(adapter);
    }
}
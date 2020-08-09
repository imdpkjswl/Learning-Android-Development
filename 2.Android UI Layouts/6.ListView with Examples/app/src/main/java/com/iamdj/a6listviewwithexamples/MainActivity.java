package com.iamdj.a6listviewwithexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayAdapter aAdapter;
    private String[] users = { "Deepak Jaiswal", "Peter Parker","David Jackson","Deepak Jaiswal", "Alan Miller", "Deepak Jaiswal","Erik","Alan Miller",
                                "Deepak Jaiswal","David Jackson","Peter Parker", "Deepak Jaiswal","Nick Johnson","Alan Miller","Deepak Jaiswal","Alan Miller"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mListView = (ListView) findViewById(R.id.userlist);
        aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, users);
        mListView.setAdapter(aAdapter);
    }
}
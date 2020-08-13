package com.iamdj.a4sharewithsocialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        String shareBody = "This contains message that gonna be shared/URL";
        myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
        startActivity(Intent.createChooser(myIntent, "Share using"));
    }
}
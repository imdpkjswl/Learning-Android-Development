package com.iamdj.a12ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RatingBar ratingBar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.rb);
        button = findViewById(R.id.btn);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        float ratingValue = ratingBar.getRating();
        Toast.makeText(this, "Rating: "+ratingValue, Toast.LENGTH_SHORT).show();
    }
}
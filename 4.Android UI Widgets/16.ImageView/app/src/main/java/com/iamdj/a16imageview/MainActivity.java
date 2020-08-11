package com.iamdj.a16imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.iv);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "How dare to click on my image ?", Toast.LENGTH_SHORT).show();
    }
}
package com.iamdj.a1textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // First access textView
        textView1 = findViewById(R.id.tv1);
        textView2 = findViewById(R.id.tv2);
        textView3 = findViewById(R.id.tv3);

        // Perform action on click
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.tv1:
                Toast.makeText(this, "Clicked First Text",Toast.LENGTH_SHORT).show();
                break;

            case R.id.tv2:
                Toast.makeText(this, "Clicked Second Text",Toast.LENGTH_SHORT).show();
                break;

            case R.id.tv3:
                Toast.makeText(this, "Clicked Third Text",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
package com.iamdj.a3passingvaluefromoneactivitytoanotheractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView textView1, textView2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1 = findViewById(R.id.tv1);
        textView2 = findViewById(R.id.tv2);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String fname = bundle.getString("FNAME");
        String lname = bundle.getString("LNAME");

        textView1.setText("First Name: "+fname);
        textView2.setText("Last Name: "+lname);

        button = findViewById(R.id.btn2);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
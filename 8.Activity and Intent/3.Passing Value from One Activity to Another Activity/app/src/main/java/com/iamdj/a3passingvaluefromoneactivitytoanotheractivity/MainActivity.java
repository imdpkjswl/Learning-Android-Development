package com.iamdj.a3passingvaluefromoneactivitytoanotheractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1, editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.et1);
        editText2 = findViewById(R.id.et2);
        button = findViewById(R.id.btn);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String fname = editText1.getText().toString().trim();
        String lname = editText2.getText().toString().trim();

        if(fname.equals("") || lname.equals("")){
            Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("FNAME",fname);
            intent.putExtra("LNAME",lname);
            startActivity(intent);
            finish();
        }


    }
}
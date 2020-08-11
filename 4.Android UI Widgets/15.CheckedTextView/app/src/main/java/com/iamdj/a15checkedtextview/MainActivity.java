package com.iamdj.a15checkedtextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CheckedTextView checkedTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkedTextView = findViewById(R.id.ctv);
        checkedTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        checkedTextView.toggle(); // make toggle to perform checked operation
        if(checkedTextView.isChecked())
            Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Unchecked", Toast.LENGTH_SHORT).show();
    }
}
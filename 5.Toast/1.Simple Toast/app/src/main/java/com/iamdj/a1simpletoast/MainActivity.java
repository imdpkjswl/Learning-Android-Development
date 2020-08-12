package com.iamdj.a1simpletoast;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button simpleButton;
    Button positionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleButton = findViewById(R.id.btn1);
        positionButton = findViewById(R.id.btn2);

        simpleButton.setOnClickListener(this);
        positionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // FOR SIMPLE TOAST
        if(R.id.btn1 == view.getId()){
            Toast.makeText(this, "This is a (SHORT) Simple Toast", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "This is a (LONG) Simple Toast", Toast.LENGTH_LONG).show();
        }

        // FOR POSITION TOAST
        if(R.id.btn2 == view.getId()){
            Toast toastTop = Toast.makeText(this,"Position Top",Toast.LENGTH_SHORT);
            toastTop.setGravity(Gravity.TOP,0,0);
            toastTop.show();


            Toast toastCenter = Toast.makeText(this,"Position Center",Toast.LENGTH_SHORT);
            toastCenter.setGravity(Gravity.CENTER,0,0);
            toastCenter.show();


            Toast toastBottom = Toast.makeText(this,"Position Bottom",Toast.LENGTH_SHORT);
            toastBottom.setGravity(Gravity.BOTTOM,0,0);
            toastBottom.show();
        }

    }
}
package com.iamdj.a8checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox cb1, cb2, cb3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        button = findViewById(R.id.btn);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String str ="You enrolled: ";
        if(cb1.isChecked()){
            str += "Java";
        }
        if(cb2.isChecked()){
            if(cb1.isChecked())
                str += ", ";
            str += "Python";
        }
        if(cb3.isChecked()){
            if(cb2.isChecked() || cb1.isChecked())
                str +=", ";
            str += "Machine Learning";
        }

        if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked()){
            str += "Nothing";
        }

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
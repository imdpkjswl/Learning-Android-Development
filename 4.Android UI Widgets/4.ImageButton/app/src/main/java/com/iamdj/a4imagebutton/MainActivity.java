package com.iamdj.a4imagebutton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText firstNum = (EditText)findViewById(R.id.firstNum);
        final EditText secNum = (EditText)findViewById(R.id.secondNum);
        ImageButton imageButton = (ImageButton)findViewById(R.id.addBtn);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstNum.getText().toString().isEmpty() || secNum.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }

                else {
                    try {
                        int num1 = Integer.parseInt(firstNum.getText().toString());
                        int num2 = Integer.parseInt(secNum.getText().toString());
                        // Here, In Toast this keyword will not work.so use getApplicationContext() method.
                        Toast.makeText(getApplicationContext(), "SUM = " + (num1 + num2), Toast.LENGTH_SHORT).show();
                    }catch (Exception e){Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();}
                }
            }


        });


    }
}
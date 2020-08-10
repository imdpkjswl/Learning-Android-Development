package com.iamdj.a5togglebutton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ToggleButton tb1 = (ToggleButton)findViewById(R.id.toggle1);
        final ToggleButton tb2 = (ToggleButton)findViewById(R.id.toggle2);
        Button btnGet = (Button)findViewById(R.id.btn);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Toggle Button1 -  " + tb1.getText().toString() + "\n" + "Toggle Button2 - " + tb2.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
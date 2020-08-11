package com.iamdj.a7switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch aSwitch;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (ConstraintLayout)findViewById(R.id.switchLayout1);
        aSwitch = (Switch)findViewById(R.id.switch1);

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(aSwitch.isChecked()){
                    layout.setBackgroundColor(Color.YELLOW);
                    Toast.makeText( getApplicationContext(), "Background Color Changed", Toast.LENGTH_SHORT).show();
                }
                else{
                    layout.setBackgroundColor(Color.WHITE);
                    Toast.makeText(MainActivity.this, "Background Color Reset", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
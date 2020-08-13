package com.iamdj.a7blink;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    Button btnblink;
    ImageView imgblink;
    Animation animBlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnblink=(Button)findViewById(R.id.btnstart);
        imgblink=(ImageView)findViewById(R.id.imganim);


        btnblink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animBlink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                imgblink.setVisibility(View.VISIBLE);
                imgblink.startAnimation(animBlink);
            }
        });

    }



}


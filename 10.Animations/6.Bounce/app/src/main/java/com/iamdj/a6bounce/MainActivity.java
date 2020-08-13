package com.iamdj.a6bounce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    Button btnbounce;
    ImageView imgbounce;
    Animation animBounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnbounce=(Button)findViewById(R.id.btnstart);
        imgbounce=(ImageView)findViewById(R.id.imganim);
        btnbounce.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                animBounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_up);
                imgbounce.setVisibility(View.VISIBLE);
                imgbounce.startAnimation(animBounce);
            }
        });

    }

}


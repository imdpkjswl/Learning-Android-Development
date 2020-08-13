package com.iamdj.a3rotate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    Button btnrotate;
    Animation animRotate;
    ImageView imgrotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnrotate=(Button)findViewById(R.id.btnstart);
        imgrotate=(ImageView)findViewById(R.id.imganim);
        btnrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animRotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                imgrotate.setVisibility(View.VISIBLE);
                imgrotate.startAnimation(animRotate);

            }
        });

    }

}
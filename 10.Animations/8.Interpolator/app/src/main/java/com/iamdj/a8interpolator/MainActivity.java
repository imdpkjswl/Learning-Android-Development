package com.iamdj.a8interpolator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {

    Button btninter;
    ImageView imginter;
    Animation animinter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btninter=(Button)findViewById(R.id.btnstart);
        imginter=(ImageView)findViewById(R.id.imganim);

        btninter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animinter = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);
                imginter.setVisibility(View.VISIBLE);
                imginter.startAnimation(animinter);
            }
        });
    }


}

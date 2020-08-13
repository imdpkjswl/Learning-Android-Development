package com.iamdj.a5slide_left_right_up_down;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {

    Button btnslideup,btnslidedown,btnslideright,btnslideleft;
    ImageView imgslide;
    Animation animSlideUp, animSlideDown,animSlideRight,animSlideLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnslideup=(Button)findViewById(R.id.btnup);
        btnslidedown=(Button)findViewById(R.id.btndown);
        btnslideleft=(Button)findViewById(R.id.btnleft);
        btnslideright=(Button)findViewById(R.id.btnright);
        imgslide=(ImageView)findViewById(R.id.imganim);



        btnslideup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
                imgslide.setVisibility(View.VISIBLE);
                imgslide.startAnimation(animSlideUp);
            }
        });



        btnslidedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
                imgslide.setVisibility(View.VISIBLE);
                imgslide.startAnimation(animSlideDown);
            }
        });



        btnslideright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animSlideRight = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_right);
                imgslide.setVisibility(View.VISIBLE);
                imgslide.startAnimation(animSlideRight);
            }
        });



        btnslideleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animSlideLeft = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_left);
                imgslide.setVisibility(View.VISIBLE);
                imgslide.startAnimation(animSlideLeft);
            }
        });

    }

}


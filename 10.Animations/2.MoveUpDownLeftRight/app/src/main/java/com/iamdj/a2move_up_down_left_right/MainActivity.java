package com.iamdj.a2move_up_down_left_right;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    Button btnmoveup,btnmovedown,btnmoveright,btnmoveleft;
    ImageView imgmove;
    Animation animMoveUp, animMoveDown,animMoveRight,animMoveLeft;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnmoveup=(Button)findViewById(R.id.btnup);
        btnmovedown=(Button)findViewById(R.id.btndown);
        btnmoveleft=(Button)findViewById(R.id.btnleft);
        btnmoveright=(Button)findViewById(R.id.btnright);
        imgmove=(ImageView)findViewById(R.id.imganim);



        btnmoveup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animMoveUp = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_up);
                imgmove.setVisibility(View.VISIBLE);
                imgmove.startAnimation(animMoveUp);
            }
        });



        btnmovedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animMoveDown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_down);
                imgmove.setVisibility(View.VISIBLE);
                imgmove.startAnimation(animMoveDown);
            }
        });



        btnmoveright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animMoveRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_right);
                imgmove.setVisibility(View.VISIBLE);
                imgmove.startAnimation(animMoveRight);
            }
        });



        btnmoveleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animMoveLeft = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_left);
                imgmove.setVisibility(View.VISIBLE);
                imgmove.startAnimation(animMoveLeft);
            }
        });


    }

}



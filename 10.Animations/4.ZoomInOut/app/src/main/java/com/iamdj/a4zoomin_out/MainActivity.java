package com.iamdj.a4zoomin_out;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    Button btnzoomin,btnzoomout;
    ImageView imgzoom;
    Animation animZoomIn, animZoomOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnzoomin=(Button)findViewById(R.id.btnin);
        btnzoomout=(Button)findViewById(R.id.btnout);
        imgzoom=(ImageView)findViewById(R.id.imganim);


        btnzoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
                imgzoom.startAnimation(animZoomIn);
            }
        });



        btnzoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
                imgzoom.startAnimation(animZoomOut);
            }
        });

    }

}

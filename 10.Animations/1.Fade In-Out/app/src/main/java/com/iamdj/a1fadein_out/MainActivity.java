package com.iamdj.a1fadein_out;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    Button btnfadein,btnfadeout;
    ImageView imgfade;
    Animation animFadeIn, animFadeOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnfadein=(Button)findViewById(R.id.btnin);
        btnfadeout=(Button)findViewById(R.id.btnout);
        imgfade=(ImageView)findViewById(R.id.imganim);


        btnfadein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                imgfade.setVisibility(View.VISIBLE);
                imgfade.startAnimation(animFadeIn);
            }
        });



        btnfadeout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                imgfade.setVisibility(View.VISIBLE);
                imgfade.startAnimation(animFadeOut);
            }
        });

    }

}

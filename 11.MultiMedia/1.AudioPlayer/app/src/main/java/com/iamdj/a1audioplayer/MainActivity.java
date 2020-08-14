package com.iamdj.a1audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView playButton, pauseButton, stopButton;
    boolean playing = false;

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.btnplay);
        pauseButton = findViewById(R.id.btnpause);
        stopButton = findViewById(R.id.btnstop);

        // Creating media player
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.maan);

        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(R.id.btnplay == view.getId()) {
            if (!playing) {
                Toast.makeText(this, "Playing", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                playing = true;
            }
        }

        if(R.id.btnpause == view.getId()) {
            if(playing){
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                playing = false;
            }
        }

        if(R.id.btnstop == view.getId()) {
            if(playing){
                Toast.makeText(this, "Stopped", Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                playing = false;
            }
        }


    }
}
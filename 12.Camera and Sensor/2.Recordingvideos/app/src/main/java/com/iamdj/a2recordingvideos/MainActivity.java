package com.iamdj.a2recordingvideos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    VideoView videoView;
    Button capVideo, capVideoWithout, playVideo;

    Uri videoFileUri;

    public static int VIDEO_CAPTURED = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.video);
        capVideo = findViewById(R.id.btn1);
        capVideoWithout = findViewById(R.id.btn2);
        playVideo = findViewById(R.id.btn3);

        capVideo.setOnClickListener(this);
        capVideoWithout.setOnClickListener(this);
        playVideo.setOnClickListener(this);

        playVideo.setEnabled(false);
    }

    @Override
    public void onClick(View view) {
        if (view == capVideo) {
            playVideo.setEnabled(true);
            Intent captureVideoIntent =new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
            startActivityForResult(captureVideoIntent,VIDEO_CAPTURED);
        }if (view == capVideoWithout) {
            playVideo.setEnabled(false);
            Intent captureVideoIntent =new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
            startActivity(captureVideoIntent);
        }else if (view == playVideo) {
            videoView.setVideoURI(videoFileUri);
            videoView.start();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == VIDEO_CAPTURED) {
            assert data != null; // optional
            videoFileUri = data.getData();
            capVideo.setEnabled(true);
        }
    }
}
package com.iamdj.a3audiorecording;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button startbtn, stopbtn, playbtn, stopplay;
    private MediaRecorder mRecorder;
    private MediaPlayer mPlayer;
    private static final String LOG_TAG = "AudioRecording";
    private static String mFileName = null;
    public static final int REQUEST_AUDIO_PERMISSION_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startbtn = (Button)findViewById(R.id.btnRecord);
        stopbtn = (Button)findViewById(R.id.btnStop);
        playbtn = (Button)findViewById(R.id.btnPlay);
        stopplay = (Button)findViewById(R.id.btnStopPlay);
        stopbtn.setEnabled(false);
        playbtn.setEnabled(false);
        stopplay.setEnabled(false);
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/AudioRecording.3gp";

        startbtn.setOnClickListener(this);
        stopbtn.setOnClickListener(this);
        playbtn.setOnClickListener(this);
        stopplay.setOnClickListener(this);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_AUDIO_PERMISSION_CODE:
                if (grantResults.length > 0) {
                    boolean permissionToRecord = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean permissionToStore = grantResults[1] ==  PackageManager.PERMISSION_GRANTED;
                    if (permissionToRecord && permissionToStore) {
                        Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }



    public boolean CheckPermissions() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }
    private void RequestPermissions() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{RECORD_AUDIO, WRITE_EXTERNAL_STORAGE}, REQUEST_AUDIO_PERMISSION_CODE);
    }


    // Perform action on button click
    @Override
    public void onClick(View view) {
        // action on start record button
        if(R.id.btnRecord == view.getId()){
            if(CheckPermissions()) {
                stopbtn.setEnabled(true);
                startbtn.setEnabled(false);
                playbtn.setEnabled(false);
                stopplay.setEnabled(false);
                mRecorder = new MediaRecorder();
                mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                mRecorder.setOutputFile(mFileName);
                try {
                    mRecorder.prepare();
                } catch (IOException e) {
                    Log.e(LOG_TAG, "prepare() failed");
                }
                mRecorder.start();
                Toast.makeText(getApplicationContext(), "Recording Started", Toast.LENGTH_LONG).show();
            }
            else
            {
                RequestPermissions();
            }
        }

        // action on stop button
        if(R.id.btnStop == view.getId()){
            stopbtn.setEnabled(false);
            startbtn.setEnabled(true);
            playbtn.setEnabled(true);
            stopplay.setEnabled(true);
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
            Toast.makeText(getApplicationContext(), "Recording Stopped", Toast.LENGTH_LONG).show();
        }

        // action on play button
        if(R.id.btnPlay == view.getId()){
            stopbtn.setEnabled(false);
            startbtn.setEnabled(true);
            playbtn.setEnabled(false);
            stopplay.setEnabled(true);
            mPlayer = new MediaPlayer();
            try {
                mPlayer.setDataSource(mFileName);
                mPlayer.prepare();
                mPlayer.start();
                Toast.makeText(getApplicationContext(), "Recording Started Playing", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Log.e(LOG_TAG, "prepare() failed");
            }
        }

        // action on stop play button
        if(R.id.btnStopPlay == view.getId()){
            mPlayer.release();
            mPlayer = null;
            stopbtn.setEnabled(false);
            startbtn.setEnabled(true);
            playbtn.setEnabled(true);
            stopplay.setEnabled(false);
            Toast.makeText(getApplicationContext(),"Playing Audio Stopped", Toast.LENGTH_SHORT).show();
        }

    }
}
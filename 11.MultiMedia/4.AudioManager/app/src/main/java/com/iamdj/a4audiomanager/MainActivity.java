package com.iamdj.a4audiomanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button silentbtn, vibratebtn, ringbtn;
    AudioManager aManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        silentbtn = (Button)findViewById(R.id.btnSilent);
        ringbtn = (Button)findViewById(R.id.btnRing);
        vibratebtn = (Button)findViewById(R.id.btnVibrate);
        aManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        int currentMode = aManager.getRingerMode();
        if(currentMode == AudioManager.RINGER_MODE_NORMAL)
            ringbtn.setBackgroundResource(R.color.colorAccent);
        else if(currentMode == AudioManager.RINGER_MODE_SILENT)
            silentbtn.setBackgroundResource(R.color.colorAccent);
        else if(currentMode == AudioManager.RINGER_MODE_VIBRATE)
            vibratebtn.setBackgroundResource(R.color.colorAccent);

        // Silent mode not working in my phone...
        silentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(getApplicationContext(),"Silent Mode Activated",Toast.LENGTH_SHORT).show();
                ringbtn.setBackgroundResource(R.color.colorPrimary);
                silentbtn.setBackgroundResource(R.color.colorAccent);
                vibratebtn.setBackgroundResource(R.color.colorPrimary);
            }
        });

        ringbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(getApplicationContext(),"Ringing Mode Activated",Toast.LENGTH_SHORT).show();
                ringbtn.setBackgroundResource(R.color.colorAccent);
                silentbtn.setBackgroundResource(R.color.colorPrimary);
                vibratebtn.setBackgroundResource(R.color.colorPrimary);
            }
        });

        vibratebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(getApplicationContext(),"Vibration Mode Activated",Toast.LENGTH_SHORT).show();
                ringbtn.setBackgroundResource(R.color.colorPrimary);
                silentbtn.setBackgroundResource(R.color.colorPrimary);
                vibratebtn.setBackgroundResource(R.color.colorAccent);
            }
        });

    }
}
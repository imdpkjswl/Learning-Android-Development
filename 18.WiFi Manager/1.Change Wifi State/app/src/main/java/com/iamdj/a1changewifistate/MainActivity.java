package com.iamdj.a1changewifistate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button enableButton, disableButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enableButton  = (Button) findViewById(R.id.btn1);
        disableButton = (Button) findViewById(R.id.btn2);

        enableButton.setOnClickListener(this);
        disableButton.setOnClickListener(this);

        disableButton.setEnabled(false);
    }

    @Override
    public void onClick(View view) {

        if(enableButton == view){
            WifiManager wifi  = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            wifi.setWifiEnabled(true);
            Toast.makeText(getApplicationContext(), "WiFi On", Toast.LENGTH_SHORT).show();

            disableButton.setEnabled(true);
            enableButton.setEnabled(false);
        }
        else if(disableButton == view){
            WifiManager wifi  = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            wifi.setWifiEnabled(false);
            Toast.makeText(getApplicationContext(), "WiFi Off", Toast.LENGTH_SHORT).show();

            enableButton.setEnabled(true);
            disableButton.setEnabled(false);
        }
    }

}
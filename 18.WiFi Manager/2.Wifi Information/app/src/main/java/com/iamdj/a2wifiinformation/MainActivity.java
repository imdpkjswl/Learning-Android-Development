package com.iamdj.a2wifiinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textWifiInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textWifiInfo = (TextView)findViewById(R.id.tv);

        String strWifiInfo = "";
        WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();

        int ipAddress = connectionInfo.getIpAddress();
        String ipString = String.format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff),
                (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));

        final int NumOfRSSILevels = 5;

        strWifiInfo +=  "SSID: " + connectionInfo.getSSID() + "\n" +
                        "BSSID: " + connectionInfo.getBSSID() + "\n" +
                        "IP Address: " + ipString + "\n" +
                        "MAC Address: " + connectionInfo.getMacAddress() + "\n" +
                        "Frequency: " + connectionInfo.getFrequency() + WifiInfo.FREQUENCY_UNITS + "\n" +
                        "LinkSpeed: " + connectionInfo.getLinkSpeed() + WifiInfo.LINK_SPEED_UNITS + "\n" +
                        "Rssi: " + connectionInfo.getRssi() + "dBm" + "\n" +
                        "Rssi Level: " + WifiManager.calculateSignalLevel(connectionInfo.getRssi(), NumOfRSSILevels) + " of " + NumOfRSSILevels;

        textWifiInfo.setText(strWifiInfo);

    }

}













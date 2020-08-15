package com.iamdj.a1phonedetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView txtphndetails;
    static final int Per = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtphndetails = (TextView) findViewById(R.id.txtdisp);
        int permissioncheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);

        if (permissioncheck == PackageManager.PERMISSION_GRANTED) {
            TelePhone();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, Per);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case Per: {
                if (grantResults.length >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    TelePhone();
                } else {
                    Toast.makeText(this, "Permission Required", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    public void TelePhone() {
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        //Get the phone type
        String strphoneType = "";
        int phoneType = tm.getPhoneType();

        switch (phoneType) {

            case (TelephonyManager.PHONE_TYPE_CDMA):
                strphoneType = "CDMA";
                break;

            case (TelephonyManager.PHONE_TYPE_GSM):
                strphoneType = "GSM";
                break;

            case (TelephonyManager.PHONE_TYPE_NONE):
                strphoneType = "NONE";
                break;
        }


        boolean isRoaming = tm.isNetworkRoaming();

        String IMEINumber = tm.getDeviceId();
        String subscriberID = tm.getDeviceId();
        String SIMSerialNumber = tm.getSimSerialNumber();
        String networkCountryISO = tm.getNetworkCountryIso();
        String SIMCountryISO = tm.getSimCountryIso();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        String softwareVersion = tm.getDeviceSoftwareVersion();
        String voiceMailNumber=tm.getVoiceMailNumber();



        String info="Phone Details:\n";
        info+="\n IMEI Number:"+IMEINumber;
        info+="\n SubscriberID:"+subscriberID;
        info+="\n Sim Serial Number:"+SIMSerialNumber;
        info+="\n Network Country ISO:"+networkCountryISO;
        info+="\n SIM Country ISO:"+SIMCountryISO;
        info+="\n Software Version:"+softwareVersion;
        info+="\n Voice Mail Number:"+voiceMailNumber;
        info+="\n Phone Network Type:"+strphoneType;
        info+="\n In Roaming :"+isRoaming;

        txtphndetails.setText(info);
    }

}
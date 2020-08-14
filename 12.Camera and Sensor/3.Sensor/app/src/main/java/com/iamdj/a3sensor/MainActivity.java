package com.iamdj.a3sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager sensorManager;
    boolean isColor = false;
    View view;
    long lastUpdate;
    boolean hasFlash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.shakeColor);  // layout background gonna be changed.
        view.setBackgroundColor(Color.GREEN);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();
    }


    // Overriding two methods of SensorEventListener
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){}

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            getAccelerometer(sensorEvent);
        }
    }

    private void getAccelerometer(SensorEvent event){
        float[] values = event.values;

        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelerationSquareRoot = (x*x + y*y + z*z)/(SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = System.currentTimeMillis();
        Toast.makeText(this, String.valueOf(accelerationSquareRoot)+" "+SensorManager.GRAVITY_EARTH, Toast.LENGTH_SHORT).show();

        if(accelerationSquareRoot >= 2) // it will be executed if we shuffle.
        {
            if(actualTime - lastUpdate < 200){
                return;
            }

            lastUpdate = actualTime;  // updating lastUpdate for next shuffle.
            if(isColor){
                hasFlash = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
                view.setBackgroundColor(Color.YELLOW);
            }else{
                view.setBackgroundColor(Color.RED);
            }

            isColor = !isColor;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(MainActivity.this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }
}
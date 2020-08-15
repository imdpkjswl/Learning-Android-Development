package com.iamdj.a1simplealarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et);
        button = findViewById(R.id.btn);

        editText.addTextChangedListener(this);
        button.setOnClickListener(this);
    }

    // For EditBox
    @Override
    public void beforeTextChanged(CharSequence s, int i, int i1, int i2) { }

    @Override
    public void onTextChanged(CharSequence s, int i, int i1, int i2) {
        if(s.toString().trim().length() == 0){
            button.setEnabled(false);
        }else{
            button.setEnabled(true);
        }
    }

    @Override
    public void afterTextChanged(Editable s) { }

    // For Button
    @Override
    public void onClick(View view) {
        startAlert();
    }

    private void startAlert() {
        int sec = Integer.parseInt(editText.getText().toString());

        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),234324243,intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +(sec*1000), pendingIntent);
        Toast.makeText(this, "Alarm set in "+sec+" seconds", Toast.LENGTH_SHORT).show();
    }
}
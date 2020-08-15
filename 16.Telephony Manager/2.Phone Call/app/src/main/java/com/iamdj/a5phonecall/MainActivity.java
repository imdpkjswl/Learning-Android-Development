package com.iamdj.a5phonecall;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button button;
    String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et);
        button = findViewById(R.id.btn);

        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        final Intent intent = new Intent(Intent.ACTION_CALL);
        num = editText.getText().toString();

        if(num.trim().isEmpty()){
            intent.setData(Uri.parse("tel:198"));
            startActivity(intent);
            Toast.makeText(this, "By default call @ 198", Toast.LENGTH_SHORT).show();
        }else {
            intent.setData(Uri.parse("tel:"+num));
            if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Please grant permission", Toast.LENGTH_SHORT).show();
                requestPermissions();
            }else{
                startActivity(intent);
            }

        }

    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
    }
}
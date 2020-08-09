package com.iamdj.a1creatingfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Create method to make action on button click
    public void sendNow(View view){
        Toast.makeText(this,"Sending data from app...",Toast.LENGTH_SHORT).show();
    }

    public void receiveNow(View view){
        Toast.makeText(this,"Receiving data from server...",Toast.LENGTH_SHORT).show();
    }

    public void deleteNow(View view){
        Toast.makeText(this,"Deleting data from app...",Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   // call onCreate activity
        setContentView(R.layout.activity_main); // set activity_main as main page.


    }
}
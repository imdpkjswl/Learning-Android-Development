package com.iamdj.a3androidactivitylifecyclemethods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hiding status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        // Debug logs
        Log.d("activity_lifecycle","onCreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("activity_lifecycle","onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("activity_lifecycle","onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("activity_lifecycle","onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("activity_lifecycle","onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("activity_lifecycle","onDestroy called");
    }

}
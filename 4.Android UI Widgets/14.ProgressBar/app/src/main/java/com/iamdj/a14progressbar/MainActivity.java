package com.iamdj.a14progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    ProgressBar progressBar;
    Button button;

    Handler handler;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv);
        progressBar = findViewById(R.id.pb);
        button = findViewById(R.id.btn);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Main code start
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(progressBar.getProgress() < 100){
                    progressBar.setProgress(progress);
                    progress++;
                    handler.postDelayed(this,100);
                    textView.setText("Wait...");
                }else
                    textView.setText("finished");

            }
        }, 100);
    }
}
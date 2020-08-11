package com.iamdj.a17textswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewSwitcher.ViewFactory {

    TextSwitcher textSwitcher;
    Button buttonPrevious, buttonNext;

    String[] qoutes = {
                        "Nobody can hurt me without my permission.",
                        "Lives as if you were to die tomorrow. Learn as if you were to live forever.",
                        "The future depends on what you do today.",
                        "Be the change that you want to see in the world.",
                        "I will not let anyone walk through my mind with their dirty feet.",
                        "You don't know who is important to you until you actually lose them."
    };

    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSwitcher = (TextSwitcher)findViewById(R.id.ts);
        buttonPrevious = (Button) findViewById(R.id.previous);
        buttonNext = (Button) findViewById(R.id.next);

        textSwitcher.setFactory(this);

        buttonNext.setOnClickListener(this);
        buttonPrevious.setOnClickListener(this);
    }
    @Override
    public View makeView() {
        TextView textView = new TextView(this);
        textView.setTextSize(22);
        textView.setTextColor(getResources().getColor(R.color.myColor));
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void onClick(View view) {

        if(R.id.next == view.getId()){
           if(index < qoutes.length-1){
               index = index + 1;
               textSwitcher.setText(qoutes[index]);
           }else
               Toast.makeText(this, "Invalid action...", Toast.LENGTH_SHORT).show();
        }
        else if(R.id.previous == view.getId()){
            if(index > 0){
                index = index - 1;
                textSwitcher.setText(qoutes[index]);
            }else
                Toast.makeText(this, "Invalid action...", Toast.LENGTH_SHORT).show();
        }
    }


}
package com.iamdj.a2customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShow = (Button)findViewById(R.id.btn);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout));
                TextView tv = (TextView) layout.findViewById(R.id.txtvw);
                tv.setText("Custom Toast Notification");
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.BOTTOM, 0, 100);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }
        });


    }

}
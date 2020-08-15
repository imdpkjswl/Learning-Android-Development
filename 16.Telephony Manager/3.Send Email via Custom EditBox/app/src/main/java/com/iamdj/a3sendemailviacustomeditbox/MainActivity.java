package com.iamdj.a3sendemailviacustomeditbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextTo,editTextSubject,editTextMessage;
    Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTo=(EditText)findViewById(R.id.edtemailto);
        editTextSubject=(EditText)findViewById(R.id.edtemailsub);
        editTextMessage=(EditText)findViewById(R.id.edtemailmsg);
        sendEmail=(Button)findViewById(R.id.btnemail);
        sendEmail.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String to=editTextTo.getText().toString();
                String subject=editTextSubject.getText().toString();
                String message=editTextMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }

        });

    }

}






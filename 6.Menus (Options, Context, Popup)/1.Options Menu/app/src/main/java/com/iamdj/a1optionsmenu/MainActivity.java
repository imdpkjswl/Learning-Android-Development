package com.iamdj.a1optionsmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle()+" selected", Toast.LENGTH_SHORT).show();

        switch(item.getItemId()){
            case R.id.item1:
                //perform action
                return true;
            case R.id.item2:
                //perform action
                return true;
            case R.id.item3:
                //perform action
                return true;
            case R.id.item4:
                //perform action
                return true;
            case R.id.subitem1:
                //perform action
                return true;
            case R.id.subitem2:
                //perform action
                return true;
            case R.id.item5:
                //perform action
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
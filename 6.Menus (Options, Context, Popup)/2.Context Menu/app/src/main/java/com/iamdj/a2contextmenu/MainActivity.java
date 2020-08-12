package com.iamdj.a2contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] course = {"Java","Kotlin","Golang","COBOL","AppleScript","FoxPro","G-Code","JavaScript","Html",
                        "Css","Python","Machine Learning","Artificial Intelligent","MySql","PHP","ANDROID"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_id);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,course);
        listView.setAdapter(adapter);

        // Register the listview for context menu
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select your plans");
        menu.add(0,v.getId(),0,"Basic $0");
        menu.add(0,v.getId(),0,"Theory: $49"); // groupid,itemid,order,title
        menu.add(0,v.getId(),0,"Theory+Practical: $79");
        menu.add(0,v.getId(),0,"Theory+Practical+Certificate: $99");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle() == "Basic $0"){
            Toast.makeText(this, "Successfully selected: $0 plan", Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle() == "Theory: $49"){
            Toast.makeText(this, "Successfully selected: $49 plan", Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle() == "Theory+Practical: $79"){
            Toast.makeText(this, "Successfully selected: $79 plan", Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle() == "Theory+Practical+Certificate: $99") {
            Toast.makeText(this, "Successfully selected: $99 plan", Toast.LENGTH_SHORT).show();
        }
        else
            return false;
        return true;
    }
}
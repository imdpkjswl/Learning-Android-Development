package com.iamdj.a4searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView searchView;
    ListView listView;

    ArrayAdapter<String> searchAdapter;
    ArrayList<String> containerSearchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.sv);
        listView = findViewById(R.id.lv);

        containerSearchList = new ArrayList<>();
        // Add items
        containerSearchList.add("Deepak");
        containerSearchList.add("David");
        containerSearchList.add("Krishna");
        containerSearchList.add("Alan");
        containerSearchList.add("Alex");
        containerSearchList.add("Ram");
        containerSearchList.add("Anish");
        containerSearchList.add("Erick");
        containerSearchList.add("Morgan");
        containerSearchList.add("Johnson");
        containerSearchList.add("Apple");
        containerSearchList.add("Michel");
        containerSearchList.add("Jaiswal");
        containerSearchList.add("Shiva");

        searchAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, containerSearchList);
        listView.setAdapter(searchAdapter);

        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if(containerSearchList.contains(query)){
            searchAdapter.getFilter().filter(query);
        }
        else{
            Toast.makeText(this, "No Match Found", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        searchAdapter.getFilter().filter(newText);
        return false;
    }
}
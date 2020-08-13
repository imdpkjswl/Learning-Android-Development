package com.iamdj.a5searchviewontoolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListView listView;

    ArrayList<String> toolList;
    ArrayAdapter<String> toolAdapter;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv);

        toolList = new ArrayList<>();
        // Add items
        toolList.add("Deepak");
        toolList.add("David");
        toolList.add("Krishna");
        toolList.add("Alan");
        toolList.add("Alex");
        toolList.add("Ram");
        toolList.add("Anish");
        toolList.add("Erick");
        toolList.add("Morgan");
        toolList.add("Johnson");
        toolList.add("Apple");
        toolList.add("Michel");
        toolList.add("Jaiswal");
        toolList.add("Shiva");

        toolAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,toolList);
        listView.setAdapter(toolAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchViewItem = menu.findItem(R.id.bar_search);

        searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchView.clearFocus();
        if(toolList.contains(query)){
            toolAdapter.getFilter().filter(query);
        }else{
            Toast.makeText(this, "No Match Found", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        toolAdapter.getFilter().filter(newText);
        return false;
    }
}
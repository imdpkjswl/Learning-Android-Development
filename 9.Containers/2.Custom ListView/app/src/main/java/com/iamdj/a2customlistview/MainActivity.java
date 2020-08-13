package com.iamdj.a2customlistview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    String[] item;
    int[] image;
    ListView listview;
    ListViewAdpter adpter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item = new String[] {"Item 1","Item 2","Item 3","Item 4","Item 5"};
        image=new int[]{R.drawable.img1,R.drawable.img2, R.drawable.img3,R.drawable.img4,R.drawable.img5};
        listview = (ListView)findViewById(R.id.listViewdemo);


        // Pass results to ListViewAdapter Class
        adpter = new  ListViewAdpter(MainActivity.this, image, item);



        // Binds the Adapter to the ListView
        listview.setAdapter(adpter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(),"item clicked",Toast.LENGTH_SHORT).show();
            }

        });

    }

}







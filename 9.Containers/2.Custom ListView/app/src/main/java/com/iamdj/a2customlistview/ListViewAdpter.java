package com.iamdj.a2customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class ListViewAdpter extends BaseAdapter {

    Context context;
    String[] item;
    int[] image;

    LayoutInflater inflater;



    public ListViewAdpter(Context context,int[] image, String[] item) {
        this.context = context;
        this.item = item;
        this.image = image;
    }



    public int getCount() {
        return item.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        TextView txtemp;
        ImageView imgflag;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.listviewlayout, parent, false);


        // Locate the TextViews in listviewlayout.xml
        txtemp = (TextView) itemView.findViewById(R.id.textView);


        // Locate the ImageView in listviewlayout.xml
        imgflag = (ImageView) itemView.findViewById(R.id.icon);


        // Capture position and set to the TextViews
        txtemp.setText(item[position]);


        // Capture position and set to the ImageView
        imgflag.setImageResource(image[position]);

        return itemView;

    }

}
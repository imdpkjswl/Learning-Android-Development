package com.iamdj.a18imageswitcher;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewSwitcher.ViewFactory {

    ImageSwitcher imageSwitcher;
    Button buttonPrevious, buttonNext;

    // NOTE: Before using img make sure about size of images.
    int[] images = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5
    };


    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSwitcher = (ImageSwitcher)findViewById(R.id.imgSwitch);
        buttonPrevious = (Button) findViewById(R.id.previous);
        buttonNext = (Button) findViewById(R.id.next);

        imageSwitcher.setFactory(this);

        buttonNext.setOnClickListener(this);
        buttonPrevious.setOnClickListener(this);
    }

    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
        return imageView;
    }

    @Override
    public void onClick(View view) {

        if(R.id.next == view.getId()){
            if(index < images.length-1){
                index = index + 1;
                imageSwitcher.setImageResource(images[index]);
            }
        }
        else if(R.id.previous == view.getId()){
            if(index > 0){
                index = index - 1;
                imageSwitcher.setImageResource(images[index]);
            }
        }
    }



}
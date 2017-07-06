package com.kelinlang.viewapp;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.kelinlang.viewapp.view.RoundImageView;

public class MainActivity extends AppCompatActivity {



    private FrameLayout container;
    private TextView textView;

    private ObjectAnimator objectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (FrameLayout)findViewById(R.id.container);
        textView = (TextView)findViewById(R.id.test);


    }


    public void onClick1(View  view){
        objectAnimator = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);
        objectAnimator.setDuration(4000);
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        objectAnimator.addUpdateListener(animation -> {
            float alpha = 1.4f - (float) animation.getAnimatedValue();


        });
        objectAnimator.start();
    }

    public void onClick2(View  view){

    }
}

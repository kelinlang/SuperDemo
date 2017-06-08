package com.kelinlang.viewapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import com.kelinlang.viewapp.view.RoundImageView;

public class MainActivity extends AppCompatActivity {

    private RoundImageView mRoundImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRoundImageView = (RoundImageView)findViewById(R.id.roundIv);
        mRoundImageView.setType(RoundImageView.TYPE_ROUND);
        mRoundImageView.setBorderRadius(50);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.fengjin,new BitmapFactory.Options());
        mRoundImageView.setImageBitmap(bitmap);
    }

}

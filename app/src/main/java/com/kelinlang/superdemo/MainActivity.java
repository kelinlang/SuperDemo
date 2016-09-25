package com.kelinlang.superdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    static {
        System.loadLibrary("test-lib");
    }

    public native String stringFromJNI();


    public native String get(String d);

    public native String getLine(String d);
}

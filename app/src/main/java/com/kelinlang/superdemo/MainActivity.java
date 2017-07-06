package com.kelinlang.superdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kelinlang.network.socket.SocketDemo;

public class MainActivity extends Activity {

    private SocketDemo mSocketDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSocketDemo =  new SocketDemo();
//        mSocketDemo.startServer();

    }



    public void onStartServer(View view){

        mSocketDemo.startServer();
    }


    public void onStopServer(View view){
        mSocketDemo.stopServer();
    }

    public void onStartClient(View view){
        mSocketDemo.startClient();
    }

    public void onStopClient(View view){
        mSocketDemo.stopClient();
    }













}

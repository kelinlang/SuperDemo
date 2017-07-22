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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.kelinlang.commonlib.log.DLog;
import com.kelinlang.commonlib.utils.json.DataJsonTranslation;
import com.kelinlang.test.FlowParamSync;
import com.kelinlang.test.PackageFlowReportInfo;
import com.kelinlang.test.PackagesFlowReportInfo;
import com.kelinlang.viewapp.view.RoundImageView;

import java.io.IOException;

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
        FlowParamSync flowParamSync = new FlowParamSync();
        flowParamSync.setUserTrafficCls(new JsonArray());
        flowParamSync.getUserTrafficCls().add("com.dudu.wifi");
        flowParamSync.getUserTrafficCls().add("com.dudu.flow");

        DLog.d(DataJsonTranslation.objectToJson(DataJsonTranslation.objectToJson(flowParamSync)));

        PackagesFlowReportInfo packagesFlowReportInfo = new PackagesFlowReportInfo();
        packagesFlowReportInfo.setReports(new JsonArray());

        PackageFlowReportInfo packageFlowReportInfo = new PackageFlowReportInfo();
        packageFlowReportInfo.setPackageName("com.dudu.wifi");
        packageFlowReportInfo.setUsedFlow("200");

        Gson gson = new Gson();
        gson.toJson(packageFlowReportInfo);

        DLog.d(DataJsonTranslation.objectToJson(DataJsonTranslation.objectToJson(packageFlowReportInfo)));

        DLog.log.debug(DataJsonTranslation.objectToJson(DataJsonTranslation.objectToJson(packageFlowReportInfo)));

        packagesFlowReportInfo.getReports().add(DataJsonTranslation.objectToJson(packageFlowReportInfo));

        packageFlowReportInfo.setPackageName("com.dudu.flow");
        packageFlowReportInfo.setUsedFlow("300");
        packagesFlowReportInfo.getReports().add(DataJsonTranslation.objectToJson(packageFlowReportInfo));


        DLog.d(DataJsonTranslation.objectToJson(DataJsonTranslation.objectToJson(packagesFlowReportInfo)));
        DLog.log.debug(DataJsonTranslation.objectToJson(DataJsonTranslation.objectToJson(packagesFlowReportInfo)));
    }



    private void testException(){

    }

    private void exception(){
        throw new IOException("dd");
    }
}

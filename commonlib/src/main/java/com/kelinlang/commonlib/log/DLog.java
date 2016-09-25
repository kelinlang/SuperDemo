package com.kelinlang.commonlib.log;

import android.util.Log;

public class DLog {
    private static final String TAG = "kelinlang";
    
    private static final boolean DEBUG = true;
    
    public static final boolean DEBUGCLOSE = true;
    public static void d(String str){
        if(DEBUGCLOSE )
            Log.d(TAG, str);
    }

    public static void i(String str){
    	if(DEBUG)
        Log.i(TAG, str);
    }
    
    public static void e(String str){
    	if(DEBUG)
        Log.e(TAG, str);
    }
    
    public static void w(String str){
    	if(DEBUG)
        Log.w(TAG, str);
    }

    public static void e(String str, Throwable e){
    	if(DEBUG)
        Log.e(TAG, str, e);
    }
}

package com.example.lsnnic.transformertest;

import android.util.Log;

public class L {

    private static final String TAG = "lsnnic";

    private static boolean sDebug = BuildConfig.DEBUG;

    public static void d(String msg,Object... args){
        if(!sDebug){
            return;
        }
        Log.d(TAG,String.format(msg,args));
    }
}

package com.example.autoopendd;

import android.app.Application;

import com.tencent.mmkv.MMKV;

public class MyApp extends Application {
    private String TAG = "openDD_MyApp";

    @Override
    public void onCreate() {
        super.onCreate();
        MMKV.initialize(this);
    }
}

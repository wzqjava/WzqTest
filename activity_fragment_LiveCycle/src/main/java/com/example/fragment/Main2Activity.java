package com.example.fragment;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    /**
     * 先执行第一个页面的onPause,再执行本页面的onResume;
     */
    @Override
    protected void onResume() {
        super.onResume();
//        Log.e("wzq-activity","第二个页面onResume");

    }
}

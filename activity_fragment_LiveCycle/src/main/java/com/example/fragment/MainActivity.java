package com.example.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioGroup;

/**
 * 动态注册fragment
 */

public class MainActivity extends FragmentActivity {

    private RadioGroup group;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("wzq-activity","onCreate");
        //获取资源ID
        group = (RadioGroup) findViewById(R.id.group);
        //拿到AFragment的实例;
        AFragment aFragment = new AFragment();

        //拿到FragmentManager管理类
        final FragmentManager supportFragmentManager = getSupportFragmentManager();

        //开启事务
        final FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.frame, aFragment);
        fragmentTransaction.commit();


        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.button01:
                        FragmentTransaction fragmentTransaction01 =  supportFragmentManager.beginTransaction();
                        fragmentTransaction01.replace(R.id.frame,new AFragment());
                        fragmentTransaction01.commit();

                        break;
                    case R.id.button02:
                        FragmentTransaction fragmentTransaction02 =  supportFragmentManager.beginTransaction();
                        fragmentTransaction02.replace(R.id.frame,new BFragment());
                        fragmentTransaction02.commit();

                        break;
                    case R.id.button03:
                        FragmentTransaction fragmentTransaction03 =  supportFragmentManager.beginTransaction();
                        fragmentTransaction03.replace(R.id.frame,new CFragment());
                        fragmentTransaction03.commit();
                        break;

                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("wzq-activity","onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("wzq-activity","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("wzq-activity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("wzq-activity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("wzq-activity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("wzq-activity","onDestroy");
    }
}

package com.example.autoopendd.activity;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autoopendd.MMKV.MMKVUtil;
import com.example.autoopendd.R;
import com.example.autoopendd.utils.MyUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MainActivity activity;
    private String TAG = "openDD_MainActivity";
    private String autoStatus = "openDD_autoStatus";//记录状态
    private String logcat = "";//日志内容
    private boolean Status = false;//Status==true的时候  才会打开其他应用
    private TextView tvContent;
    private TextView tvClearLog;
    private TextView tvStatus;

    private ScreenStatusReceiver mScreenStatusReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int flags = WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
        getWindow().addFlags(flags);
        setContentView(R.layout.activity_main);

        KeyguardManager km = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock kl = km.newKeyguardLock("StartupReceiver");//参数是LogCat里用的Tag
        kl.disableKeyguard();
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!MyUtils.isIsMain()) {
            MyUtils.setIsMain(true);
            initData();
        }
    }

    private void initView() {
        activity = this;
        tvContent = findViewById(R.id.ac_main_tv_content);
        tvClearLog = findViewById(R.id.ac_main_tv_clearLog);
        tvClearLog.setOnClickListener(this);
        tvStatus = findViewById(R.id.ac_main_tv_status);
        tvStatus.setOnClickListener(this);

        registSreenStatusReceiver();//注册广播
    }

    private void initData() {
        logcat = MMKVUtil.get(TAG, "日志记录");
        Status = MMKVUtil.get(autoStatus, false);
        logcat = logcat + "\ninitData";
        setTvContent(logcat);
        setStatus(Status);
    }

    //获取当前时间
    private String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String format = simpleDateFormat.format(date);
        return format;
    }

    //更新日志面板 显示的内容
    private void setTvContent(String logcat) {
        tvContent.setText(logcat);
    }

    //更新开关按钮状态
    private void setStatus(boolean status) {
        if (status) {
            tvStatus.setText("开");
        } else {
            tvStatus.setText("关");
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ac_main_tv_clearLog) {
            MMKVUtil.remove(TAG);
            logcat = "";
            tvContent.setText("");
        } else if (id == R.id.ac_main_tv_status) {
            Status = !Status;
            setStatus(Status);
        }
    }

    @Override
    protected void onUserLeaveHint() {//HOME键
        super.onUserLeaveHint();
        MMKVUtil.set(TAG, logcat + "\nHOME键:" + getDate());
        MMKVUtil.set(autoStatus, Status);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {//菜单键
        super.onOptionsMenuClosed(menu);
        MMKVUtil.set(TAG, logcat + "\n菜单键:" + getDate());
        MMKVUtil.set(autoStatus, Status);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mScreenStatusReceiver) {
            unregisterReceiver(mScreenStatusReceiver);
        }
        MMKVUtil.set(TAG, logcat + "\nonDestroy:" + getDate());
        MMKVUtil.set(autoStatus, Status);
    }

    private void registSreenStatusReceiver() {
        mScreenStatusReceiver = new ScreenStatusReceiver();
        IntentFilter screenStatusIF = new IntentFilter();
        screenStatusIF.addAction(Intent.ACTION_SCREEN_ON);
        screenStatusIF.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mScreenStatusReceiver, screenStatusIF);
    }

    class ScreenStatusReceiver extends BroadcastReceiver {
        private String SCREEN_ON = "android.intent.action.SCREEN_ON";
        private String SCREEN_OFF = "android.intent.action.SCREEN_OFF";

        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if (SCREEN_ON.equals(intent.getAction())) {
                    Log.e(TAG, "onReceive: 屏幕亮了");
                    if (Status) {
                        String intentLog = MMKVUtil.get(TAG, "日志记录");
                        intentLog = intentLog + "\n亮屏:" + getDate();
                        Intent intent1 = new Intent(activity, OpenDDActivity.class);
                        intent1.putExtra("TAG", intentLog);
                        startActivity(intent1);
                        return;
                    }
                    logcat = logcat + "\n亮屏:" + getDate();
                    Log.e(TAG, "logcat: " + logcat);
                    setTvContent(logcat);
                } else if (SCREEN_OFF.equals(intent.getAction())) {
                    Log.e(TAG, "onReceive: 屏幕暗了");
                    logcat = logcat + "\n暗屏:" + getDate();
                    MMKVUtil.set(TAG, logcat);
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(TAG, "onReceive catch: " + e.getMessage());
            }
        }
    }
}

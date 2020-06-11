package com.example.autoopendd.activity;

import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autoopendd.MMKV.MMKVUtil;
import com.example.autoopendd.R;
import com.example.autoopendd.utils.MyUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OpenDDActivity extends AppCompatActivity {

    private String DDPackageName = "com.alibaba.android.rimet";
    private String TAG = "openDD_MainActivity";
    private String autoStatus = "openDD_autoStatus";//记录状态
    private String logcat = "";

    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int flags = WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
        getWindow().addFlags(flags);
        setContentView(R.layout.activity_open_dd);

        //屏幕解锁
        KeyguardManager km = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock kl = km.newKeyguardLock("StartupReceiver");//参数是LogCat里用的Tag
        kl.disableKeyguard();

        MyUtils.setIsMain(false);
        initView();
        MMKVUtil.set(autoStatus, true);
    }

    private void initView() {
        tvContent = findViewById(R.id.ac_openDD_tv_content);

        Intent intent = getIntent();
        logcat = intent.getStringExtra("TAG");
        setTvContent(logcat);
        openPackageName(DDPackageName);
    }

    //更新日志面板 显示的内容
    private void setTvContent(String logcat) {
        tvContent.setText(logcat);
    }

    private void openPackageName(final String openPackageName) {
        Log.e(TAG, "PackageName: " + openPackageName);
        try {
            logcat = logcat + "\n尝试打开:DD ----" + getDate();

            // 通过包名获取此APP详细信息，包括Activities、services、versioncode、name等等
            PackageInfo packageinfo = null;
            try {
                packageinfo = getPackageManager().getPackageInfo(openPackageName, 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            if (packageinfo == null) {
                logcat = logcat + "\n尝试打开失败: 未安装该应用" + "----" + getDate();
                setTvContent(logcat);
                return;
            }
            // 创建一个类别为CATEGORY_LAUNCHER的该包名的Intent
            Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
            resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            resolveIntent.setPackage(packageinfo.packageName);

            // 通过getPackageManager()的queryIntentActivities方法遍历
            List<ResolveInfo> resolveinfoList = getPackageManager()
                    .queryIntentActivities(resolveIntent, 0);
            ResolveInfo resolveinfo = resolveinfoList.iterator().next();
            if (resolveinfo != null) {
                // packagename = 参数packname
                final String packageName = resolveinfo.activityInfo.packageName;
                // 这个就是我们要找的该APP的LAUNCHER的Activity[组织形式：packagename.mainActivityname]
                final String className = resolveinfo.activityInfo.name;
                // LAUNCHER Intent
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                // 设置ComponentName参数1:packagename参数2:MainActivity路径
                ComponentName cn = new ComponentName(packageName, className);
                intent.setComponent(cn);
                startActivity(intent);
                logcat = logcat + "\n尝试打开成功" + "----" + getDate();
                finish();
            } else {
                logcat = logcat + "\n尝试打开失败: 未安装该应用" + "----" + getDate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            logcat = logcat + "\n尝试打开失败: 未安装该应用 或者 打开应用失败" + "----" + getDate();
            setTvContent(logcat);
        }
    }

    private String getDate() {
        //获取当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String format = simpleDateFormat.format(date);
        return format;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        MMKVUtil.set(TAG, logcat);
        finish();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MMKVUtil.set(TAG, logcat);
    }
}

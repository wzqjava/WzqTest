package com.wzq.mintentservice;

/**
 * <p>作者：王志强<p>
 * <p>创建时间：2020/6/17<p>
 * <p>文件描述：<p>
 * https://www.cnblogs.com/it-tsz/p/11601265.html
 */

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.jetbrains.annotations.Nullable;

public class MyService extends IntentService {

    public static final String BROADCAST_ACTION = "com.example.android.threadsample.BROADCAST";
    private static final String TAG = MyService.class.getSimpleName();
    private LocalBroadcastManager mLocalBroadcastManager;
    private int count = 0;
    @Nullable
    public static final String EXTENDED_DATA_STATUS = "key_param";

    public MyService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //在这里添加我们要执行的代码，Intent中可以保存我们所需的数据，
        //每一次通过Intent发送的命令将被顺序执行
        count++;
        Log.e(TAG, "count::" + count);
        //接收参数，做耗时的处理，处理完毕，发送Broadcat
        //将数据打印出来
        //接收到数据，做耗时处理
        String result = downloadHtml(intent.getDataString());
        Log.i("result", result);
        //将耗时操作的结果放进Intent，调用LocalBroadcastManager.sendBroadcast将intent传递回去
        Intent localIntent = new Intent(BROADCAST_ACTION);
        localIntent.putExtra(EXTENDED_DATA_STATUS, result);
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        mLocalBroadcastManager.sendBroadcast(localIntent);

    }

    private String downloadHtml(String dataString) {
        try {
            URL url = new URL(dataString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream in = conn.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
            in.close();
            Log.i("html", out.toByteArray().toString());
            return new String(out.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
package wzq.com.handlerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * handler的高级研究;
 */
public class MainActivity extends Activity {
    private Button btnSendToWorkUI;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 在UI线程中开启一个子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 在子线程中初始化一个Looper对象
                Looper.prepare();
                handler=new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        // 把UI线程发送来的消息显示到屏幕上。
                        Log.i("main", "what="+msg.what+","+msg.obj);
                        //可以反复弹吐司
                        Toast.makeText(MainActivity.this, "what="+msg.what+","+msg.obj, Toast.LENGTH_SHORT).show();
//                        btnSendToWorkUI.setText("更新ui了");//不能更新ui;
                    }
                };
                // 把刚才初始化的Looper对象运行起来，循环消息队列的消息
                Looper.loop();

            }
        }).start();

        btnSendToWorkUI=(Button)findViewById(R.id.btnSendToWorkUI);

        btnSendToWorkUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // onClick方法是运行在UI线程上的
                Message msg=Message.obtain();
                msg.what=1;
                msg.obj="向子线程中发送消息！";
                // 向子线程中发送消息
                handler.sendMessage(msg);
                new Thread(){
                    @Override
                    public void run() {

                        super.run();
                        Looper.prepare();

                        //崩溃Can't create handler inside thread that has not called Looper.prepare()
                        //调用完loop就可以发消息
                        Toast.makeText(MainActivity.this, "子线程单独发toast", Toast.LENGTH_SHORT).show();
//                         btnSendToWorkUI.setText("更新ui了");//不能更新ui;崩溃;

                        Looper.loop();
                    }

                }.start();
            }


        });


    }


}

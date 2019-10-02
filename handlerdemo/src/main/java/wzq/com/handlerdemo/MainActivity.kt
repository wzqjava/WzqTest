package wzq.com.handlerdemo

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * handler的高级研究;
 */
class MainActivity : Activity() {
    private var threadHandler: Handler? = null  // 这是子线程的handler
    private var textView: TextView? = null
    private var btnSendToWorkUI: Button? = null
    private var button2: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initThreadHandler()
        setListener()
    }

    private fun initThreadHandler() {
        // 在UI线程中开启一个子线程
        Thread(Runnable {
            // 在子线程中初始化一个Looper对象
            Looper.prepare()
            threadHandler = object : Handler() {
                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    // 把UI线程发送来的消息显示到屏幕上。
                    Log.i(TAG, "what=" + msg.what + "," + msg.obj)
                    //可以反复弹吐司
                    Toast.makeText(this@MainActivity, "what=" + msg.what + "," + msg.obj, Toast.LENGTH_SHORT).show()
                    //            btnSendToWorkUI.setText("更新ui了");//不能更新ui;
                    //            textView.setText(msg.obj.toString()); //崩溃,子线程不能更新UI;
                }
            }
            // 把刚才初始化的Looper对象运行起来，循环消息队列的消息
            Looper.loop()
        }).start()
    }

    private fun initView() {
        btnSendToWorkUI = findViewById(R.id.btnSendToWorkUI)
        button2 = findViewById(R.id.button2)
        textView = findViewById(R.id.textView)
    }

    private fun setListener() {
        btnSendToWorkUI!!.setOnClickListener {
            // onClick方法是运行在UI线程上的
            val msg = Message.obtain()
            msg.what = 1
            msg.obj = "向子线程中发送消息！"

            threadHandler!!.sendMessage(msg) // 主线程向子线程中发送消息
        }
        button2!!.setOnClickListener { view ->
            object : Thread() {
                override fun run() {
                    super.run()
                    Tasks.post2UI (Runnable { button2!!.text = "我改变了自己" } )
                }
            }.start()
        }

    }

    companion object {
        private val TAG = "MainActivity"
    }


}


package com.wzq.mintentservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.wzq.mintentservice.R.id

class MainActivity : AppCompatActivity() {
    var receiver = MyReceiver()
    open lateinit var mTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        regist()
        bindView()
    }

    private fun regist() {
        val intentFilter = IntentFilter(MyService.BROADCAST_ACTION)
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT)
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, intentFilter)
    }

    private fun bindView() {
        mTextView = findViewById<View>(id.textView) as TextView
        val button: Button = findViewById<View>(id.button) as Button
        button.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                val serviceIntent = Intent(this@MainActivity, MyService::class.java)
                serviceIntent.data = Uri.parse("http://www.baidu.com")
                startService(serviceIntent)
            }
        })
    }

    class MyReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            val data: String = intent.getStringExtra(MyService.EXTENDED_DATA_STATUS)
            Log.e("test", data)
            Toast.makeText(context, data, Toast.LENGTH_LONG).show()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver)
    }
}

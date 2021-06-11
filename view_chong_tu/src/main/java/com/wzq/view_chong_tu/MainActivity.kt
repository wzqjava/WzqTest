package com.wzq.view_chong_tu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * 开发艺术与探索, 事件冲突拦截
 * https://blog.csdn.net/l664675249/article/details/50766523
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var findViewById = findViewById<View>(R.id.moveView)
        findViewById.setOnClickListener {
            startActivity(Intent(this, Main2Activity::class.java))
        }

    }


    fun startMain2(view: View?) {
        startActivity(Intent(this, Main2Activity::class.java))
    }

}
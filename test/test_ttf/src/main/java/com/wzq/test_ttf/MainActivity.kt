package com.wzq.test_ttf

import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mTextView = findViewById<TextView>(R.id.textView)
        val typeface: Typeface = Typeface.createFromAsset(assets, "fonts/KaiXinSong2_1.ttf")
        mTextView.setTypeface(typeface);
        mTextView.text = ("顗 的简体字\n" +
                "巘 的简体字\n" +
                "璊 的简体字\n" +
                "龑 的简体字\n" +
                "頔 的简体字\n" +
                "瓅 的简体字\n" +
                "鋐 的简体字\n" +
                "韡 的简体字\n" +
                "緌 的简体字\n" +
                "澫 的简体字")


    }


}
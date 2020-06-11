package com.wzq.a02_combineview

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import com.wzq.a02_combineview.R.layout

/**
 * 作者：王志强
 * 创建时间：2020/6/11
 * 文件描述：
 */
class TitleView(context: Context?, attrs: AttributeSet?) : FrameLayout(context!!, attrs) {
    private val leftButton: Button
    private val titleText: TextView

    init {
        LayoutInflater.from(context).inflate(layout.title, this)
        titleText = findViewById<View>(R.id.title_text) as TextView
        leftButton = findViewById<View>(R.id.button_left) as Button
        leftButton.setOnClickListener { (getContext() as Activity).finish() }
    }

    fun setTitleText(text: String?) {
        titleText.text = text
    }

    fun setLeftButtonText(text: String?) {
        leftButton.text = text
    }

    fun setLeftButtonListener(l: OnClickListener?) {
        leftButton.setOnClickListener(l)
    }

}
package com.wzq.a01_viewclick

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.view.View.OnClickListener

/**
 *<p>作者：王志强<p>
 * <p>创建时间：2020/6/11<p>
 * <p>文件描述：<p>
 *
 */
class CounterView : View, OnClickListener {
    private var mPaint: Paint
    private var mBounds: Rect
    private var mCount = 0

    constructor(context: Context?, attr: AttributeSet?) : super(context, attr) {
        this.mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        this.mBounds = Rect()
        setOnClickListener(this)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mPaint.color = Color.BLUE
        canvas.drawRect(0F, 0F, getWidth().toFloat(), getHeight().toFloat(), mPaint)
        mPaint.color = Color.YELLOW
        mPaint.textSize = 30F
        val text = mCount.toString()
        mPaint.getTextBounds(text, 0, text.length, mBounds)
        val textWidth: Int = mBounds.width()
        val textHeight: Int = mBounds.height()
        canvas.drawText(
                text, (getWidth() / 2 - textWidth / 2).toFloat(), (getHeight() / 2 + textHeight / 2).toFloat(), mPaint
        )
    }

    override fun onClick(v: View?) {
        mCount++
        invalidate()
    }

}
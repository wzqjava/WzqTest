package com.itheima.mytogglebutton

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.View.OnClickListener
import com.itheima.mytogglebutton.R.drawable

class MyToggleButtonView(context: Context?, attrs: AttributeSet?) : View(context, attrs), OnClickListener {
    private var paint: Paint? = null

    /***
     * 在Android系统中，一个视图（View）从创建到显示过程中的主要方法 1.构造方法 2.测量-onMeasure(int,int);
     * 当前View是ViewGroup,还有义务测量孩子的宽和高 3.指定位置和大小-onLayout(boolean,int,int,int,int)
     * 当前View是ViewGroup，必须要指定孩子的位置和大小 4.绘制-onDraw(canvas);
     */
    private var backgroudBitmap: Bitmap? = null
    private var slideBitmap: Bitmap? = null

    /**
     * 距离左边的距离
     */
    private var slideLeft = 0f

    /**
     * 距离左边最大距离
     */
    private var slideLeftMax = 0f

    /**
     * 初始化View
     */
    private fun initView() {
        paint = Paint()
        // 抗锯齿
        paint!!.isAntiAlias = true
        paint!!.color = Color.RED
        backgroudBitmap = BitmapFactory.decodeResource(
                resources, drawable.switch_background
        )
        slideBitmap = BitmapFactory.decodeResource(
                resources, drawable.slide_button
        )
        slideLeftMax = backgroudBitmap!!.getWidth() - slideBitmap?.getWidth()!!.toFloat()
        // 对当前控件设置点击事件
        setOnClickListener(this)
    }

    /**
     * 测量视图
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // TODO Auto-generated method stub
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 根据背景图片指定宽和高
        setMeasuredDimension(
                backgroudBitmap!!.width, backgroudBitmap!!.height
        )
    }

    /**
     * 视图的绘制
     */
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // canvas.drawColor(Color.RED);
        // canvas.drawCircle(40, 40, 50, paint);
        canvas.drawBitmap(backgroudBitmap, 0f, 0f, paint)
        canvas.drawBitmap(slideBitmap, slideLeft, 0f, paint)
    }

    /**
     * 按钮是否是开的状态 true:开的状态 false:关的状态
     */
    private var isOpen = true

    /**
     * 是否点击事件可用
     * true:点击事件可用，但是触摸事件不可用
     * flase:点击事件不可用，但是触摸事件可用
     */
    private var isClickEnable = false
    override fun onClick(v: View) {
        if (isClickEnable) {
            isOpen = !isOpen
            flushStatus()
        }
    }

    private fun flushStatus() {
        slideLeft = if (isOpen) {
            // 开
            slideLeftMax
        } else {
            0f
        }
        // 那个方法会导致重新绘制
        invalidate()
    }

    /**
     * 第一次按下的X轴坐标
     */
    private var startX = 0f

    /**
     * 记录第一次按下的历史值
     */
    private var lastX = 0f
    override fun onTouchEvent(event: MotionEvent): Boolean {
        super.onTouchEvent(event) // 执行父类的onTouchEvent()方法
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                println("onTouchEvent-ACTION_DOWN")
                run {
                    startX = event.x
                    lastX = startX
                }
                isClickEnable = true
            }
            MotionEvent.ACTION_MOVE -> {
                println("onTouchEvent-ACTION_MOVE")
                //2.来到新的坐标点
                val newX = event.x
                //3.技术偏移量
                val distanceX = newX - startX
                if (Math.abs(newX - lastX) > 5) {
                    isClickEnable = false
                }
                //4.根据移动的坐标更新控件的位置
                flushView(distanceX)
                //5.重新计算起始坐标
                startX = event.x
            }
            MotionEvent.ACTION_UP -> {
                println("onTouchEvent-ACTION_UP")
                if (!isClickEnable) {
                    /**
                     * slideLeft > slideLeftMax/2  开
                     * slideLeft <= slideLeftMax/2 关
                     */
                    if (slideLeft > slideLeftMax / 2) {
                        isOpen = true
                    } else if (slideLeft <= slideLeftMax / 2) {
                        isOpen = false
                    }
                    flushStatus()
                }
            }
            else -> {
            }
        }
        return true
    }

    private fun flushView(distanceX: Float) {
        slideLeft += distanceX
        //屏蔽非法值
        if (slideLeft > slideLeftMax) {
            slideLeft = slideLeftMax
        }
        if (slideLeft < 0) {
            slideLeft = 0f
        }
        invalidate() //onDraw();
    }

    init {
        initView()
    }
}
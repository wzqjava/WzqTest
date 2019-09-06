package com.itheima.mytogglebutton;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyToggleButtonView extends View implements View.OnClickListener {

  private Paint paint;

  /***
   * 在Android系统中，一个视图（View）从创建到显示过程中的主要方法 1.构造方法 2.测量-onMeasure(int,int);
   * 当前View是ViewGroup,还有义务测量孩子的宽和高 3.指定位置和大小-onLayout(boolean,int,int,int,int)
   * 当前View是ViewGroup，必须要指定孩子的位置和大小 4.绘制-onDraw(canvas);
   */

  private Bitmap backgroudBitmap;
  private Bitmap slideBitmap;

  /**
   * 距离左边的距离
   */
  private float slideLeft;
  /**
   * 距离左边最大距离
   */
  private float slideLeftMax;

  public MyToggleButtonView(Context context, AttributeSet attrs) {
    super(context, attrs);
    initView();
  }




  /**
   * 初始化View
   */
  private void initView() {
    paint = new Paint();

    // 抗锯齿
    paint.setAntiAlias(true);
    paint.setColor(Color.RED);

    backgroudBitmap = BitmapFactory.decodeResource(getResources(),
        R.drawable.switch_background);
    slideBitmap = BitmapFactory.decodeResource(getResources(),
        R.drawable.slide_button);

    slideLeftMax = backgroudBitmap.getWidth() - slideBitmap.getWidth();
    // 对当前控件设置点击事件
    setOnClickListener(this);

  }

  /**
   * 测量视图
   */
  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    // TODO Auto-generated method stub
    // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    // 根据背景图片指定宽和高
    setMeasuredDimension(backgroudBitmap.getWidth(),
        backgroudBitmap.getHeight());
  }

  /**
   * 视图的绘制
   */
  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    // canvas.drawColor(Color.RED);
    // canvas.drawCircle(40, 40, 50, paint);
    canvas.drawBitmap(backgroudBitmap, 0, 0, paint);
    canvas.drawBitmap(slideBitmap, slideLeft, 0, paint);

  }

  /**
   * 按钮是否是开的状态 true:开的状态 false:关的状态
   */
  private boolean isOpen = true;

  /**
   * 是否点击事件可用
   * true:点击事件可用，但是触摸事件不可用
   * flase:点击事件不可用，但是触摸事件可用
   */
  private boolean isClickEnable = false;;

  @Override
  public void onClick(View v) {
    if(isClickEnable){
      isOpen = !isOpen;
      flushStatus();
    }

  }

  private void flushStatus() {
    if (isOpen) {
      // 开
      slideLeft = slideLeftMax;
    } else {
      slideLeft = 0;
    }

    // 那个方法会导致重新绘制
    invalidate();
  }

  /**
   * 第一次按下的X轴坐标
   */
  private float startX;
  /**
   * 记录第一次按下的历史值
   */
  private float lastX;

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    super.onTouchEvent(event);// 执行父类的onTouchEvent()方法
    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:// 按下
        System.out.println("onTouchEvent-ACTION_DOWN");
        //1.第一次按下记录坐标
        lastX = startX = event.getX();
        isClickEnable = true;

        break;
      case MotionEvent.ACTION_MOVE:// 移动
        System.out.println("onTouchEvent-ACTION_MOVE");
        //2.来到新的坐标点
        float newX = event.getX();

        //3.技术偏移量
        float distanceX = newX - startX;

        if(Math.abs(newX - lastX) > 5){
          isClickEnable = false;
        }

        //4.根据移动的坐标更新控件的位置
        flushView(distanceX);

        //5.重新计算起始坐标
        startX = event.getX();


        break;
      case MotionEvent.ACTION_UP:// 离开
        System.out.println("onTouchEvent-ACTION_UP");

        if(!isClickEnable){
          /**
           * slideLeft > slideLeftMax/2  开
           slideLeft <= slideLeftMax/2 关
           */

          if(slideLeft > slideLeftMax/2){
            isOpen = true;
          }else if(slideLeft <= slideLeftMax/2){
            isOpen = false;
          }

          flushStatus();
        }

        break;

      default:
        break;
    }
    return true;
  }

  private void flushView(float distanceX) {
    slideLeft += distanceX;
    //屏蔽非法值
    if(slideLeft >slideLeftMax){
      slideLeft = slideLeftMax;
    }
    if(slideLeft < 0){
      slideLeft = 0;
    }

    invalidate();//onDraw();
  }

}

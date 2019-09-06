package com.itheima.myscrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

public class MyScrollView extends ViewGroup {

  // 实现滑动效果
  // 1.手势识别器的定义
  private GestureDetector detector;

  private Scroller scroller;

  // 1.定义接口

  /**
   * 监听页面的下标改变
   */
  interface PageChangeListener {
    /**
     * 当页面改变的时候，回调这个方法
     *
     * @param currentIndex : 当前页面的下标
     */
    public void moveTo(int currentIndex);
  }

  private PageChangeListener pageChangeListener;

  /**
   * 设置页面下标改变的监听，给Activity使用的方法
   *
   * @param pageChangeListener
   */
  public void setPageChangeListener(PageChangeListener pageChangeListener) {
    this.pageChangeListener = pageChangeListener;
  }

  /**
   * 带有两个参数的构造方法
   *
   * @param context
   * @param attrs
   */
  public MyScrollView(Context context, AttributeSet attrs) {
    super(context, attrs);
    initView(context);
  }

  /**
   * 初始化View
   *
   * @param context
   */
  private void initView(Context context) {

    scroller = new Scroller(context);
    // 2.实例化手势识别器
    detector = new GestureDetector(context,
        new GestureDetector.SimpleOnGestureListener() {

          /**
           * distanceX:在水平方向要移动的距离 distanceY:在竖直方向要移动的距离
           */
          @Override
          public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                  float distanceX, float distanceY) {

            /**
             * x:在水平方向移动指定的距离 y:在竖直方向移动指定的距离
             */
            scrollBy((int) distanceX, 0);

            /**
             * 移动到指定的坐标 x:移动到的X轴坐标 y:移动到的Y轴坐标
             */
            // scrollTo(x, y);
            return true;
          }

        });
  }

  private float startX;

  /**
   * 当前页面的下标
   */
  private int currentIndex;

  /**
   * 事件的分发
   * 一般是不需要实现的
   */
  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    // TODO Auto-generated method stub
    return super.dispatchTouchEvent(ev);
  }

  /**
   * 1.如果当前View是ViewGroup，将有义务测量孩子，如果是View就测量自身
   * 2.测量的过程，先测量父类，再测量孩子。
   * 3.widthMeasureSpec里面包含父类给孩子的宽和父类给孩子的模式
   * 4.父类给孩子的模式：未指定；一定范围内；至多
   * 5.测量View的过程中不只测量一次 总结：
   * a,widthMeasureSpec得到父类给孩子的宽和父类给孩子的模式
   * b,计算控件的宽，距离右边的距离减掉padding得到宽度
   * c,通过MeasureSpec.getSize(widthMeasureSpec)和MeasureSpec
   * .makeMeasureSpec(size, mode) 重新得到孩子的宽度
   * d,MeasureSpec.makeMeasureSpec(size, mode)测量值
   */
  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    // 遍历所有的孩子，测量

    int size = MeasureSpec.getSize(widthMeasureSpec);
    int mode = MeasureSpec.getMode(widthMeasureSpec);
    // int newWidth = MeasureSpec.makeMeasureSpec(size, mode);
    getWidth();
    System.out.println("size==" + size + ",mode==" + mode);
    for (int i = 0; i < getChildCount(); i++) {
      View child = getChildAt(i);
      // 把父类给孩子的宽和高全部给了孩子
      child.measure(widthMeasureSpec, heightMeasureSpec);
    }
  }

  private float downX;
  private float downY;

  /**
   * 当这个方法返回true的时候，将会拦截事件，导致触发当前View的onTuchEvent();
   * 当这个方法返回false的时候，将会把事件继续传给孩子
   */
  @Override
  public boolean onInterceptTouchEvent(MotionEvent ev) {

    boolean result = false;
    switch (ev.getAction()) {
      case MotionEvent.ACTION_DOWN://按下
        detector.onTouchEvent(ev);
        System.out.println("onInterceptTouchEvent==ACTION_DOWN");
        //1.记录按下的坐标
        downX = ev.getX();
        downY = ev.getY();

        break;
      case MotionEvent.ACTION_MOVE://移动
        System.out.println("onInterceptTouchEvent==ACTION_MOVE");
        //2.移动来到新的坐标
        float newX = ev.getX();
        float newY = ev.getY();

        //3.计算偏移量
        float distanceX = Math.abs(newX - downX);//必须有滑动，防止只有按下也滑动
        float distanceY = Math.abs(newY - downY);

        if (distanceX>distanceY && distanceX>5) {
          result = true;
        }

        break;

      case MotionEvent.ACTION_UP://离开
        System.out.println("onInterceptTouchEvent==ACTION_UP");

        break;

    }

    System.out.println("onInterceptTouchEvent==" + result);
    return result;
  }

  // 3.使用手势识别器
  @Override
  public boolean onTouchEvent(MotionEvent event) {
//      super.onTouchEvent(event);// 执行父类的onTouchEvent方法
    System.out.println("onTouchEvent==");
    detector.onTouchEvent(event);
    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:// 按下
        System.out.println("onTouchEvent==ACTION_DOWN");
        // 1.记录手指按下屏幕的坐标
        startX = event.getX();

        break;
      case MotionEvent.ACTION_MOVE:// 滑动
        System.out.println("onTouchEvent==ACTION_MOVE");

        break;
      case MotionEvent.ACTION_UP:// 离开
        System.out.println("onTouchEvent==ACTION_UP");

        // 2.来到新的坐标
        float endX = event.getX();

        int tempIndex = currentIndex;

        // 3.计算偏移量
        if ((endX - startX) > getWidth() / 2) {
          // 归位上一个页面
          tempIndex--;
        } else if ((startX - endX) > getWidth() / 2) {
          // 归位下一个页面
          tempIndex++;
        }

        moveTo(tempIndex);

        break;
    }
    return true;
  }

  /**
   * 根据下标位置，移动到指定的页面
   *
   * @param tempIndex 页面的下标
   */
  public void moveTo(int tempIndex) {
    // 屏蔽非法值
    if (tempIndex < 0) {
      tempIndex = 0;
    }
    if (tempIndex > getChildCount() - 1) {
      tempIndex = getChildCount() - 1;
    }

    // 移动到指定的坐标
    // tempIndex*getWidth():X轴的坐标
    // 0:Y轴的坐标，但是是没有移动的

    // 起始坐标是多少
    // getScrollX();

    currentIndex = tempIndex;

    if (pageChangeListener != null) {
      pageChangeListener.moveTo(currentIndex);
    }

    // 移动的距离是多少
    float distanceX = currentIndex * getWidth() - getScrollX();
    // 结束坐标
    // tempIndex*getWidth();

    // scrollTo(tempIndex*getWidth(), 0);
    // scroller.startScroll(getScrollX(), 0, distanceX, 0);
    // scroller.startScroll(getScrollX(), 0, (int) distanceX, 0);

    scroller.startScroll(getScrollX(), 0, (int) distanceX, 0,
        (int) Math.abs(distanceX));

    invalidate();// 导致onDraw();还导致computeScroll();

  }

  @Override
  public void computeScroll() {
    super.computeScroll();
    if (scroller.computeScrollOffset()) {

      // 得到要移动到的坐标
      float currX = scroller.getCurrX();

      scrollTo((int) currX, 0);

      invalidate();// 会导致computeScroll方法执行

    }

  }

  /**
   * 布局显示过程中的一个方法，如果当前View是ViewGroup，有义务指定孩子的大小和位置
   */
  @Override
  protected void onLayout(boolean changed, int l, int t, int r, int b) {
    // 指定每一个孩子的位置和大小
    for (int i = 0; i < getChildCount(); i++) {
      View child = getChildAt(i);
      // 指定孩子的位置和大小
      child.layout(i * getWidth(), 0, getWidth() + i * getWidth(),
          getHeight());
    }

  }

}

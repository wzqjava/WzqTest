package com.itheima.myscrollview;

import android.os.SystemClock;

public class MyScroller {

  /**
   * 移动的X轴的起始坐标
   */
  private float startX;
  /**
   * 移动的Y轴的起始坐标
   */
  private float startY;
  /**
   * 在X轴要要移动的距离
   */
  private float distanceX;
  /**
   * 在Y轴要要移动的距离
   */
  private float distanceY;
  /**
   * 开始时间
   */
  private long startTime;
  /**
   * 判断是否移动结束
   * false:没有结束
   * true:移动结束
   */
  private boolean isFinish;

  /**
   * 人为指定移动动画总时间为500毫秒
   */
  private long totalTime = 500;
  private float currX;

  /**
   * 开始移动了
   * @param startX
   * @param startY
   * @param distanceX
   * @param distanceY
   */
  public void startScroll(float startX,float startY,float distanceX,float distanceY){
    this.startX = startX;
    this.startY = startY;
    this.distanceX = distanceX;
    this.distanceY = distanceY;
    this.startTime = SystemClock.uptimeMillis();//开机时间
    this.isFinish = false;

  }

  /**
   * 计算这一小段的距离和对应的坐标和花的时间和平均速度
   * @return 判断是否还在移动
   * true:就是还在移动
   * false:移动结束
   */
  public boolean computeScrollOffset(){

    if(isFinish){
      return false;
    }

    //移动者一小段结束的时间
    long endTime = SystemClock.uptimeMillis();

    //计算这一小段花的时间
    long passTime = endTime - startTime;

    if(passTime < totalTime){
      //还在移动，还没有结束
      //计算这一小段的距离和对应的坐标和平均速度
      //距离= 时间*速度
      //在X轴方向的速度
//			float velocityX = distanceX / totalTime;
      //这一小片的距离
      float distancXSmall =  passTime *  distanceX / totalTime;
      //转换成要移动到的坐标
      currX = startX + distancXSmall;

    }else{
      //移动结束
      currX = startX + distanceX;
      isFinish = true;
    }

    return true;
  }

  public float getCurrX() {
    return currX;
  }


}

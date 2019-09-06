package com.itheima.myscrollview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.itheima.myscrollview.MyScrollView.PageChangeListener;

public class MainActivity extends Activity {

  private MyScrollView myscrollView;
  private RadioGroup radiogroup;

  // 图片ID集合
  private int[] ids = { R.drawable.a1, R.drawable.a2, R.drawable.a3,
      R.drawable.a4, R.drawable.a5, R.drawable.a6 };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    myscrollView = (MyScrollView) findViewById(R.id.myscrollView);
    radiogroup = (RadioGroup) findViewById(R.id.radiogroup);

    for(int i=0;i<ids.length;i++){
      //对应的页面
      ImageView imageView = new ImageView(this);
      imageView.setBackgroundResource(ids[i]);

      //把每一个页面添加到自定义的MyScrollView 这个类总
      myscrollView.addView(imageView);


    }

    //添加测试页面
    View test = View.inflate(this, R.layout.test, null);
    myscrollView.addView(test, 2);

    //添加指示点
    for(int i=0;i<myscrollView.getChildCount();i++){
      RadioButton button = new RadioButton(this);
      button.setId(i);//0~5
      radiogroup.addView(button);
      if(i == 0){
        button.setChecked(true);
      }

    }

    //设置页面改变的监听
    myscrollView.setPageChangeListener(new PageChangeListener() {

      //currentIndex:0~5
      //radioButton的ID和MyScrollView页面的下标一一对应
      @Override
      public void moveTo(int currentIndex) {

        // 把所有的变成默认效果
//				for(int i=0;i<radiogroup.getChildCount();i++){
//					RadioButton button = (RadioButton) radiogroup.getChildAt(i);
//					button.setChecked(false);
//				}
//
//				//把当前的变成高亮
//				RadioButton button =(RadioButton) radiogroup.getChildAt(currentIndex);
//				button.setChecked(true);

        radiogroup.check(currentIndex);

      }
    });


    //设置RadioGroup点击状态的监听
    radiogroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
      //checkedId 和对应的MyScrollView页面的下标一一对应
      //checkedId
      @Override
      public void onCheckedChanged(RadioGroup group, int checkedId) {
        myscrollView.moveTo(checkedId);
      }
    });

  }

}

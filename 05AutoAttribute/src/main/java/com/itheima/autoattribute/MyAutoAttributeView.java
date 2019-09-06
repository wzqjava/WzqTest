package com.itheima.autoattribute;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyAutoAttributeView extends View {
	
	private int my_age;
	private String my_name;
	private Bitmap bitmap;

	/**
	 * Android系统下了死规定，在布局文件中， 使用该类的时候，实例化该类，将会调用带有两个参数的构造方法
	 * 
	 * @param context
	 * @param attrs
	 */
	public MyAutoAttributeView(Context context, AttributeSet attrs) {
		super(context, attrs);

		// 得到属性的三种方式
		// 1.用命名空间
		String age = attrs.getAttributeValue(
				"http://schemas.android.com/apk/res/com.itheima.autoattribute",
				"my_age");
		String name = attrs.getAttributeValue(
				"http://schemas.android.com/apk/res/com.itheima.autoattribute",
				"my_name");
		String bg = attrs.getAttributeValue(
				"http://schemas.android.com/apk/res/com.itheima.autoattribute",
				"my_bg");

		// System.out.println(age+" :  "+name+"   :  "+bg);

		// 2.遍历属性
		for (int i = 0; i < attrs.getAttributeCount(); i++) {
			String value = attrs.getAttributeValue(i);
			System.out.println(attrs.getAttributeName(i) + "==" + value);
		}

		// 3.采用系统工具
		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.MyAutoAttributeView);
		for (int i = 0; i < ta.getIndexCount(); i++) {
			// 得到控件的ID
			int id = ta.getIndex(i);
			switch (id) {
			case R.styleable.MyAutoAttributeView_my_age://年龄
				
				 my_age = ta.getInt(id, 0);
				break;
			case R.styleable.MyAutoAttributeView_my_name://姓名
				 my_name = ta.getString(id);

				break;
			case R.styleable.MyAutoAttributeView_my_bg://图片
				Drawable icon = ta.getDrawable(id);
				BitmapDrawable draw = (BitmapDrawable) icon;
				bitmap = draw.getBitmap();
				

				break;

			default:
				break;
			}

		}

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		Log.e("MyAutoAttributeView","onDraw----");
		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setTextSize(50);
		paint.setAntiAlias(true);
		canvas.drawText(my_name+" " +my_age, getWidth()/2, getHeight()/2, paint );
		canvas.drawBitmap(bitmap,getWidth()/2, getHeight()/2, paint);
	}

}

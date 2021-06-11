package com.wzq.view_chong_tu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by zyb on 2017/6/26.
 */

public class MoveView extends View {

    private int mLastX;
    private int mLastY;

    public MoveView(Context context) {
        super(context);
    }

    public MoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = rawX - mLastX;
                int deltaY = rawY = mLastY;
                setTranslationX(deltaX);
                setTranslationY(deltaY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        mLastX = rawX;
        mLastY = rawY;
        return super.onTouchEvent(event);
    }
}

package com.wzq.view_chong_tu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Scroller;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created by zyb on 2017/6/26.
 */

public class ScrollerTest extends AppCompatTextView {

    private Scroller mScroller = new Scroller(getContext());

    public ScrollerTest(Context context) {
        super(context);
    }

    public ScrollerTest(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollerTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int deltaX = destX - scrollX;
        mScroller.startScroll(scrollX, 0, deltaX, 0, 1000);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        smoothScrollTo(100,40);
        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }
}

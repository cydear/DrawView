package com.draw.code.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 自定义view
 *
 * @author lary.huang
 * @version v 1.4.8 2017/7/17 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class MyView01 extends View {
    public MyView01(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightSpec = MeasureSpec.getMode(heightMeasureSpec);

        Log.d("TAG", "-----------------pre------------------------");
        Log.d("TAG", "widthSize=" + widthSize);
        Log.d("TAG", "widthMode=" + widthMode);
        Log.d("TAG", "heightSize=" + heightSize);
        Log.d("TAG", "heightSpec=" + heightSpec);
        Log.d("TAG", "width=" + getMeasuredWidth());
        Log.d("TAG", "height=" + getMeasuredHeight());
        Log.d("TAG", "-----------------pre  end------------------------");
        setMeasuredDimension(200, 200);
        Log.d("TAG", "-----------------after------------------------");
        Log.d("TAG", "width=" + getMeasuredWidth());
        Log.d("TAG", "height=" + getMeasuredHeight());
        Log.d("TAG", "-----------------after  end------------------------");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }
}

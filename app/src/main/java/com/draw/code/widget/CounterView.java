package com.draw.code.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2017/7/17 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class CounterView extends View implements View.OnClickListener {
    private int count = 0;
    private Paint mPaint;
    private Rect mBounds;

    public CounterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mBounds = new Rect();
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(80);
        String text = String.valueOf(count);

        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        float fontHeight = fontMetrics.bottom - fontMetrics.top;
        float textBaseY = getHeight() - (getHeight() - fontHeight) / 2 - fontMetrics.bottom;

        float fontWidth = mPaint.measureText(text);
        float textBaseX = (getWidth() - fontWidth) / 2;
        canvas.drawText(text, textBaseX, textBaseY, mPaint);
    }

    @Override
    public void onClick(View v) {
        count++;
        invalidate();
    }
}

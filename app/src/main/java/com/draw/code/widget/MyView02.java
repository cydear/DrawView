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
public class MyView02 extends View {
    private Paint mPaint;

    public MyView02(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(20);
        String text = "Hello View";
        //获取paint字体信息
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        //计算文字高度
        float fontHeight = fontMetrics.bottom - fontMetrics.top;
        //计算文字高度的baseline
        float textBaseY = getHeight() - (getHeight() - fontHeight) / 2 - fontMetrics.bottom;

        //获取字体的长度
        float fontWidth = mPaint.measureText(text);
        //计算文字长度的baseline
        float textBaseX = (getWidth() - fontWidth) / 2;
        canvas.drawText(text, textBaseX, textBaseY, mPaint);
    }
}

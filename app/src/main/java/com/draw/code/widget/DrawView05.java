package com.draw.code.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.draw.code.R;
import com.draw.code.util.MeasureUtils;

/**
 * Bitmap  PorterDuffColorFilter色彩混合
 *
 * @author lary.huang
 * @version v 1.4.8 2017/7/18 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class DrawView05 extends View {
    private Paint mPaint;
    private int leftX, leftY;
    private Bitmap bitmap;

    public DrawView05(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        //初始化Paint  设置抗锯齿
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img01);
        int[] screenSize = MeasureUtils.getScreenSize(context);
        leftX = screenSize[0] / 2 - bitmap.getWidth() / 2;
        leftY = screenSize[1] / 2 - bitmap.getHeight() / 2;

        //设置ColorMatrix  PorterDuffColorFilter色彩混合
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, leftX, leftY, mPaint);
    }
}

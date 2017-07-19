package com.draw.code.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.draw.code.R;
import com.draw.code.util.MeasureUtils;

/**
 * DST_OUT
 *
 * @author lary.huang
 * @version v 1.4.8 2017/7/18 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class DrawView08 extends View {
    private Paint mPaint;
    private PorterDuffXfermode porterDuffXfermode;
    private int x, y, screenW, screenH;
    private Bitmap bitmap;

    public DrawView08(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //DST_OUT模式: 只在目标图像和源图像相交的以外的地方绘制目标图像
        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a3_mask);

        int[] screenSize = MeasureUtils.getScreenSize(context);
        screenW = screenSize[0];
        screenH = screenSize[1];

        x = screenW / 2 - bitmap.getWidth() / 2;
        y = screenH / 2 - bitmap.getHeight() / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);
        //绘制目标图像
        canvas.drawColor(0xFF8f66DA);
        //设置混合图像模式
        mPaint.setXfermode(porterDuffXfermode);
        //绘制源图像
        canvas.drawBitmap(bitmap, x, y, mPaint);
        //还原混合模式
        mPaint.setXfermode(null);
        //还原画布
        canvas.restoreToCount(sc);
    }
}

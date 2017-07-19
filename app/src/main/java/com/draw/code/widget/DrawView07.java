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
 * DST_IN
 *
 * @author lary.huang
 * @version v 1.4.8 2017/7/18 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class DrawView07 extends View {
    private Paint mPaint;
    private Bitmap srcBitmap, dstBitmap;
    private PorterDuffXfermode porterDuffXfermode;
    private int d_l, d_t, s_l, s_t, screenW, screenH;

    public DrawView07(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a3_mask);
        dstBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a3);
        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

        int[] screenSize = MeasureUtils.getScreenSize(context);
        screenW = screenSize[0];
        screenH = screenSize[1];
        d_l = screenSize[0] / 2 - dstBitmap.getWidth() / 2;
        d_t = screenSize[1] / 2 - dstBitmap.getHeight() / 2;
        s_l = screenSize[0] / 2 - srcBitmap.getWidth() / 2;
        s_t = screenSize[1] / 2 - srcBitmap.getHeight() / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBitmap, d_l, d_t, mPaint);
        //设置混合模式
        mPaint.setXfermode(porterDuffXfermode);
        canvas.drawBitmap(srcBitmap, s_l, s_t, mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(sc);
    }
}

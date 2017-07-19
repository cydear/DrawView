package com.draw.code.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.draw.code.util.DisplayUtils;

/**
 * Created by oumind on 2017/7/18.
 */
public class DrawView08 extends View {
    private Paint mPaint;
    private int smallRadius = 100, bigRadius = 250, innerRadius = 230, centerRadius = 190;
    private int screenW, screenH;
    private int sl_x, sl_y, sr_x, sr_y, bc_x, bc_y;
    private static int rectW = 800;
    private static int d = 100;
    private int rect_x, rect_y;
    private int hw = 25, hh = 130, hl, ht;
    private int mw = 100, mh = 25, ml, mt;

    public DrawView08(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        int[] screenSize = DisplayUtils.getScreenSize(context);
        screenW = screenSize[0];
        screenH = screenSize[1];

        rect_x = screenW / 2 - rectW / 2;
        rect_y = screenH / 2 - rectW / 2;

        sl_x = rect_x + (rectW - smallRadius * 2 - d) / 2;
        sl_y = rect_y + (rectW / 2 - smallRadius * 2) / 2 + smallRadius;

        sr_x = sl_x + d + smallRadius * 2;
        sr_y = sl_y;

        bc_x = rect_x + rectW / 2;
        bc_y = rect_y + rectW / 2;

        hl = bc_x - hw / 2;
        ht = bc_y - hh + hw / 2;

        ml = bc_x - mh / 2;
        mt = bc_y - mh + mh / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制大矩形
        mPaint.setARGB(255, 238, 106, 80);
        canvas.drawRect(rect_x, rect_y, rect_x + rectW, rect_y + rectW, mPaint);
        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);
        mPaint.setARGB(255, 255, 255, 255);
        canvas.drawCircle(sl_x, sl_y, smallRadius, mPaint);
        canvas.drawCircle(sr_x, sr_y, smallRadius, mPaint);

        mPaint.setARGB(255, 238, 106, 80);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawCircle(bc_x, bc_y, bigRadius, mPaint);
        mPaint.setXfermode(null);

        int sc2 = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);
        mPaint.setARGB(255, 255, 255, 255);
        canvas.drawCircle(bc_x, bc_y, innerRadius, mPaint);
        mPaint.setARGB(255, 238, 106, 80);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawCircle(bc_x, bc_y, centerRadius, mPaint);
        mPaint.setXfermode(null);

        mPaint.setARGB(255, 255, 255, 255);
        canvas.drawRect(hl, ht, hl + hw, ht + hh, mPaint);
        canvas.drawRect(ml, mt, ml + mw, mt + mh, mPaint);

        canvas.restoreToCount(sc2);
        canvas.restoreToCount(sc);
    }
}

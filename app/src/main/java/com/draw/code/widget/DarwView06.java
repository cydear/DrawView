package com.draw.code.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.draw.code.bo.PorterDuffBO;
import com.draw.code.util.MeasureUtils;

/**
 * Porter 混和模式
 *
 * @author lary.huang
 * @version v 1.4.8 2017/7/18 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class DarwView06 extends View {
    //PorterDuff模式常量
    private static final PorterDuff.Mode MODE = PorterDuff.Mode.DST_ATOP;

    private static final int RECT_SIZE_SMALL = 400;//左右上方示例渐变正方形的尺寸大小
    private static final int RECT_SIZE_BIG = 400;//中间渐变正方形的尺寸大小

    private Paint mPaint;//画笔

    private PorterDuffBO porterDuffBO;
    private PorterDuffXfermode porterDuffXfermode;

    private int screenW, screenH;
    private int s_l, s_t;//左上方正方形原点坐标
    private int d_l, d_t;//右上方正方形的原点坐标
    private int rectX, rectY;//中间正方形的原点坐标

    public DarwView06(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        porterDuffBO = new PorterDuffBO();

        porterDuffXfermode = new PorterDuffXfermode(MODE);

        calculate(context);
    }

    private void calculate(Context context) {
        int[] screenSize = MeasureUtils.getScreenSize(context);
        screenW = screenSize[0];
        screenH = screenSize[1];

        s_l = 0;
        s_t = 0;
        d_l = screenW - RECT_SIZE_SMALL;
        d_t = 0;

        rectX = screenW / 2 - RECT_SIZE_BIG / 2;
        rectY = RECT_SIZE_SMALL + (screenH - RECT_SIZE_SMALL) / 2 - RECT_SIZE_BIG / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画布颜色为黑色
        canvas.drawColor(Color.BLACK);
        //设置业务对象的尺寸
        porterDuffBO.setSize(RECT_SIZE_SMALL);

        //左上方的正方形
        canvas.drawBitmap(porterDuffBO.initSrcBitmap(), s_l, s_t, mPaint);
        canvas.drawBitmap(porterDuffBO.initDisBitmap(), d_l, d_t, mPaint);

        //将绘制操作保存至新的图层
        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);

        porterDuffBO.setSize(RECT_SIZE_BIG);

        //绘制目标图
        canvas.drawBitmap(porterDuffBO.initDisBitmap(), rectX, rectY, mPaint);
        //设置混合模式
        mPaint.setXfermode(porterDuffXfermode);
        //绘制源图
        canvas.drawBitmap(porterDuffBO.initSrcBitmap(), rectX, rectY, mPaint);
        //还原混合模式
        mPaint.setXfermode(null);
        //还原画布
        canvas.restoreToCount(sc);
    }
}

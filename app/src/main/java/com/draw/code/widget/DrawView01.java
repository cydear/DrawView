package com.draw.code.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.draw.code.util.MeasureUtils;

/**
 * ColorMatrixFilter
 *
 * @author lary.huang
 * @version v 1.4.8 2017/7/18 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class DrawView01 extends View {
    private Paint mPaint;
    private Context mContext;

    public DrawView01(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        //打开抗锯齿
        mPaint.setAntiAlias(true);
        /**
         * 设置画笔描边的样式
         * Paint.Style.FILL：描边
         * Paint.Style.FILL_AND_STROKE：描边并填充
         * Paint.Style.STROKE：填充
         */
        mPaint.setStyle(Paint.Style.FILL);
        //设置画笔颜色为自定义颜色
        mPaint.setARGB(255, 255, 128, 103);
        //设置画笔描边的宽度 单位：px
        mPaint.setStrokeWidth(10);
        //设置色彩矩阵
        ColorMatrix matrix = new ColorMatrix(new float[]{
                0.5F, 0, 0, 0, 0,
                0, 0.5F, 0, 0, 0,
                0, 0, 0.5F, 0, 0,
                0, 0, 0, 0.5F, 0
        });
        mPaint.setColorFilter(new ColorMatrixColorFilter(matrix));
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int[] screenSize = MeasureUtils.getScreenSize(mContext);
        int width = screenSize[0];
        int height = screenSize[1];
        canvas.drawCircle(width / 2, height / 2, 200, mPaint);
    }
}

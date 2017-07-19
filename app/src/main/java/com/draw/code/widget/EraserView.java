package com.draw.code.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.draw.code.R;
import com.draw.code.util.MeasureUtils;

public class EraserView extends View {
    //最小移动距离
    private static final int MIN_MOVE_DIS = 5;
    //前景橡皮擦bitmap和背景bitmap
    private Bitmap fgBitmap, bgBitmap;
    //绘制橡皮擦路径的画布
    private Canvas mCanvas;
    //绘制橡皮擦路径的画笔
    private Paint mPaint;
    //橡皮擦绘制路径
    private Path mPath;

    private int screenW, screenH;

    private float preX, preY;

    public EraserView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        caculate(context);

        init(context);
    }

    private void init(Context context) {
        mPath = new Path();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        //设置画笔的透明度为0是关键,我们要让绘制的路径是透明的，然后让该路径和前景色的底色混合抠出绘制路径
        mPaint.setARGB(128, 255, 0, 0);
        //设置混合模式DST_IN
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        //设置画笔风格为描边
        mPaint.setStyle(Paint.Style.STROKE);
        //设置路径结合处的样式
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        //设置笔触类型
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        //设置描边宽度
        mPaint.setStrokeWidth(50);
        //生成前景图片
        fgBitmap = Bitmap.createBitmap(screenW, screenH, Bitmap.Config.ARGB_8888);
        //将前景图片注入画布
        mCanvas = new Canvas(fgBitmap);
        //绘制画布背景为中性灰
        mCanvas.drawColor(0xFF808080);
        //获取背景底图
        bgBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a4);
        //缩放背景底图至屏幕大小
        bgBitmap = Bitmap.createScaledBitmap(bgBitmap, screenW, screenH, true);
    }

    private void caculate(Context context) {
        int[] screen = MeasureUtils.getScreenSize(context);
        screenW = screen[0];
        screenH = screen[1];
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制背景b
        canvas.drawBitmap(bgBitmap, 0, 0, null);
        //绘制前景
        canvas.drawBitmap(fgBitmap, 0, 0, null);
        //绘制path
        mCanvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //当手指按下时 重置path
                mPath.reset();
                mPath.moveTo(x, y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                float destX = Math.abs(x - preX);
                float destY = Math.abs(y - preY);
                if (destX >= MIN_MOVE_DIS || destY >= MIN_MOVE_DIS) {
                    mPath.quadTo(preX, preY, (x + preX) / 2, (y + preY) / 2);
                    preX = x;
                    preY = y;
                }
                break;
        }
        invalidate();
        return true;
    }
}
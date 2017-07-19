package com.draw.code.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.draw.code.R;
import com.draw.code.util.MeasureUtils;

/**
 * 通过LightingColorFilter设置背景
 *
 * @author lary.huang
 * @version v 1.4.8 2017/7/18 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class DrawView04 extends View {
    private Paint mPaint;
    private int leftX, leftY;
    private Bitmap bitmap;
    private boolean isClick;

    public DrawView04(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.start);
        int[] screenSize = MeasureUtils.getScreenSize(context);
        leftX = screenSize[0] / 2 - bitmap.getWidth() / 2;
        leftY = screenSize[1] / 2 - bitmap.getHeight() / 2;
        isClick = false;
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClick) {
                    mPaint.setColorFilter(null);
                } else {
                    mPaint.setColorFilter(new LightingColorFilter(0xFFFFFFF, 0X00FFFF00));
                }
                isClick = !isClick;
                //重新绘制
                invalidate();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, leftX, leftY, mPaint);
    }
}

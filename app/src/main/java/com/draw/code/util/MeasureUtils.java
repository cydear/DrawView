package com.draw.code.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @author lary.huang
 * @version v 1.4.8 2017/7/18 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class MeasureUtils {
    public static int[] getScreenSize(Context context) {
        int[] size = new int[2];
        DisplayMetrics dm = new DisplayMetrics();
        if (context instanceof Activity) {
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
            size[0] = dm.widthPixels;
            size[1] = dm.heightPixels;
        }
        return size;
    }
}

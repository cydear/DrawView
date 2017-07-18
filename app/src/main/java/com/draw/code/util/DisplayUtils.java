package com.draw.code.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by oumind on 2017/7/18.
 */

public class DisplayUtils {
    public static int[] getScreenSize(Context context) {
        int[] size = new int[2];
        if (context instanceof Activity) {
            DisplayMetrics dm = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
            size[0] = dm.widthPixels;
            size[1] = dm.heightPixels;
        }
        return size;
    }
}

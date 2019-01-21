package com.sunyjams.domain.utils;

import android.content.Context;

/**
 * Created by James
 * Date 2019/1/21.
 * description
 */
public class ScreenUtil {

    public static int convertDpToPixel(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }
}

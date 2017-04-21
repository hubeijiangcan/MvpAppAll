package com.mitbbs.mvpappall.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by jc on 2017/4/19.
 */
public class MeasureUtils {
    private MeasureUtils() {
        throw new AssertionError();
    }

    public static float dp2px(Context context,float dp){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,
                context.getResources().getDisplayMetrics());
    }

    public static float sp2px(Context context, float sp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                context.getResources().getDisplayMetrics());
    }
}

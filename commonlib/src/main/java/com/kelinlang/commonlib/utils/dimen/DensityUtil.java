package com.kelinlang.commonlib.utils.dimen;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * Author: Robert
 * Date:  2016-08-29
 * Copyright (c) 2016,dudu Co.,Ltd. All rights reserved.
 * Desc: 屏幕密度转换类
 */
public class DensityUtil {
    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     *
     * @param pxValue （DisplayMetrics类中属性density）
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param dipValue （DisplayMetrics类中属性density）
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 获取屏幕详细信息
     *
     * DisplayMetrics dm = context.getResources().getDisplayMetrics();
     * 像素密度类型	                                 ldpi	    mdpi 	  hdpi	      xhdpi 	  xxhdpi	xxxhdpi
     *
     * DPI范围（每英寸的打印点数）                 [0~160)   [160~240)	[240~320)	[320~480)	[480~640)	[640~)       dm.densityDpi得到的数值
     *
     * PPI范围（每英寸像素数）	                   [0~120)	 [120~160)	[160~240)	[240~320)	[320~480)	[480~640)     dm.xdpi和dm.ydpi得到的数值
     *
     *"同一个切图在不同dpi文件夹下大小比例关系"	    0.75x	   1x	     1.5x	      2x	      3x	      4x         dm.density得到的数值
     *
     * @param context
     * @return
     */
    public static DisplayMetrics getScreenInfo(Activity context) {

        DisplayMetrics dm = context.getResources().getDisplayMetrics();
//        Log.i("ScreenInfo:","dm.widthPixels = "+dm.widthPixels+",dm.heightPixels = "+dm.heightPixels);  //例如：对于1280x400的屏幕，这个获取到的是1187x400，并非真实分辨率

        Point point = new Point();
//        context.getWindowManager().getDefaultDisplay().getSize(point); //例如：对于1280x400的屏幕，这个获取到的是1187x400，并非真实分辨率
        context.getWindowManager().getDefaultDisplay().getRealSize(point); //例如：对于1280x400的屏幕，这个获取到的是1280x400，是真实分辨率


        double x = Math.pow(point.x/ dm.xdpi, 2);
        double y = Math.pow(point.y / dm.ydpi, 2);
        double screenInches = Math.sqrt(x + y);

        Log.i("ScreenInfo","分辨率："+point.x+"x"+point.y+",屏幕打印点密度DPI(逻辑dpi值 )："+dm.densityDpi+",dp->px比例："+dm.density+",sp->px比例:"+dm.scaledDensity);
        Log.i("ScreenInfo","每英寸像素数PPI（真是dpi值）:xdpi："+dm.xdpi+",ydpi:"+dm.ydpi+",屏幕尺寸（对角线英寸数）："+screenInches+"英寸");

        return dm;
    }

}
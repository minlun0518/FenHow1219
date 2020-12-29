package com.lunlun.fenhow1219.ui.slideshow;

import android.content.Context;

public class CustomGrid {
    private Context context;
    private final String[] appName;
    private final int[] appImageId;
    private final boolean[] appStatue;
    private final boolean[] appLock;

    public CustomGrid(Context context, String[] appName, int[] appImageId,boolean[] appStatue,boolean[] appLock) {
        this.context = context;
        this.appName = appName;
        this.appImageId = appImageId;
        this.appStatue = appStatue;
        this.appLock=appLock;
    }

}

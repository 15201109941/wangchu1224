package com.bawei.app;

import android.content.Context;

import com.uuzuche.lib_zxing.ZApplication;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/*
 *@auther:王楚
 *@Date: 2019/12/27
 *@Time:10:21
 *@Description:${DESCRIPTION}
 **/
public class MyApp extends ZApplication {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        ZXingLibrary.initDisplayOpinion(this);
    }
}

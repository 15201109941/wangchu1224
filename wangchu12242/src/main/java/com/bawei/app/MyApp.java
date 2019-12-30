package com.bawei.app;

import android.app.Application;
import android.content.Context;

/*
 *@auther:王楚
 *@Date: 2019/12/24
 *@Time:13:49
 *@Description:${DESCRIPTION}
 **/
public class MyApp extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}

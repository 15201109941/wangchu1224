package com.bawei;

import com.bawei.app.MyApp;

/*
 *@auther:王楚
 *@Date: 2019/12/30
 *@Time:8:52
 *@Description:${DESCRIPTION}
 **/
public interface Contract {
    interface MyCallBack<T>{
        void onRuccess(String url);
        void onError(String error);
    }
    interface View{
        void onRuccess(String url);
        void onError(String error);
    }
    interface Model{
        void getInfoPram(String url,Class cls,MyCallBack myCallBack);
    }
    interface Presenter{
        void getInfoPram(String url,Class cls);
    }
}

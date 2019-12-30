package com.bawei;

import java.util.Map;

/*
 *@auther:王楚
 *@Date: 2019/12/24
 *@Time:14:16
 *@Description:${DESCRIPTION}
 **/
public interface Contract {
    interface MyCallBack<T>{
        void onRuccess(T v);
        void onError(String error);
    }
    interface View<T>{
        void onRuccess(T v);
        void onError(String error);
    }
    interface Model{
        void getNoPram(String url,Class cls,MyCallBack myCallBack);
        void getInfoPram(String url, Map<String,Object>map,Class cls,MyCallBack myCallBack);
        void postInfoPram(String url, Map<String,Object>map,Class cls,MyCallBack myCallBack);
    }
    interface Presenter{
        void getNoPram(String url,Class cls);
        void getInfoPram(String url,Map<String,Object>map,Class cls);
        void postInfoPram(String url,Map<String,Object>map,Class cls);
    }
}

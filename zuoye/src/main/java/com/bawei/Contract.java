package com.bawei;

/*
 *@auther:王楚
 *@Date: 2019/12/29
 *@Time:19:15
 *@Description:${DESCRIPTION}
 **/
public interface Contract {
    interface MyCallBack{
        void onRuccess(String url);
        void onError(String error);
    }
}

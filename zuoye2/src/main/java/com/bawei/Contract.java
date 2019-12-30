package com.bawei;

/*
 *@auther:王楚
 *@Date: 2019/12/29
 *@Time:20:11
 *@Description:${DESCRIPTION}
 **/
public interface Contract {
    interface MyCallBack {
        void onSuccess(String url);

        void onError(Throwable throwable);
    }

    interface IView {
        void onSuccess(String url);

        void onError(Throwable throwable);
    }

    interface IModel {
        void getInfoParams(String url, MyCallBack myCallBack);
    }

    interface IPresenter {
        void getInfoParams(String url);
    }
}

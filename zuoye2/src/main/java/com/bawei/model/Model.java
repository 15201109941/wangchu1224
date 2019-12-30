package com.bawei.model;


import com.bawei.Contract;
import com.bawei.util.HttpUtil;

public class Model implements Contract.IModel {
    @Override
    public void getInfoParams(String url, final Contract.MyCallBack myCallBack) {
        HttpUtil.getInstance().getInfo(url, new HttpUtil.NetCallBack() {
            @Override
            public void onSuccess(String url) {
                myCallBack.onSuccess(url);

            }

            @Override
            public void onError(Throwable throwable) {
                myCallBack.onError(throwable);
            }
        });
    }
}
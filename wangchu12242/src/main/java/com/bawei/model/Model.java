package com.bawei.model;

import com.bawei.Contract;
import com.bawei.util.HttpUtil;

import java.util.Map;

/*
 *@auther:王楚
 *@Date: 2019/12/24
 *@Time:14:24
 *@Description:${DESCRIPTION}
 **/
public class Model implements Contract.Model {
    @Override
    public void getNoPram(String url, Class cls, final Contract.MyCallBack myCallBack) {
        HttpUtil.getInstance().getNoPram(url, cls, new HttpUtil.MyCallBack() {
            @Override
            public void onRuccess(Object v) {
                myCallBack.onRuccess(v);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }

    @Override
    public void getInfoPram(String url, Map<String, Object> map, Class cls, final Contract.MyCallBack myCallBack) {
        HttpUtil.getInstance().getInfoPram(url, map, cls, new HttpUtil.MyCallBack() {
            @Override
            public void onRuccess(Object v) {
                myCallBack.onRuccess(v);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }

    @Override
    public void postInfoPram(String url, Map<String, Object> map, Class cls, final Contract.MyCallBack myCallBack) {
        HttpUtil.getInstance().postInfoPram(url, map, cls, new HttpUtil.MyCallBack() {
            @Override
            public void onRuccess(Object v) {
                myCallBack.onRuccess(v);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }
}

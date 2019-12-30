package com.bawei.presenter;

import com.bawei.Contract;
import com.bawei.base.BasePresenter;
import com.bawei.model.Model;

import java.util.Map;

/*
 *@auther:王楚
 *@Date: 2019/12/24
 *@Time:14:26
 *@Description:${DESCRIPTION}
 **/
public class Presenter extends BasePresenter {
    private Contract.Model model;
    @Override
    protected void initModel() {
        model=new Model();
    }

    @Override
    public void getNoPram(String url, Class cls) {
        model.getNoPram(url, cls, new Contract.MyCallBack() {
            @Override
            public void onRuccess(Object v) {
                getView().onRuccess(v);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }

    @Override
    public void getInfoPram(String url, Map<String, Object> map, Class cls) {
        model.getInfoPram(url, map, cls, new Contract.MyCallBack() {
            @Override
            public void onRuccess(Object v) {
                getView().onRuccess(v);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }

    @Override
    public void postInfoPram(String url, Map<String, Object> map, Class cls) {
        model.postInfoPram(url, map, cls, new Contract.MyCallBack() {
            @Override
            public void onRuccess(Object v) {
                getView().onRuccess(v);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}

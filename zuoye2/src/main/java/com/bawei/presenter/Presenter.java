package com.bawei.presenter;


import com.bawei.Contract;
import com.bawei.base.BasePresenter;
import com.bawei.model.Model;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void getInfoParams(String url) {
        iModel.getInfoParams(url, new Contract.MyCallBack() {
            @Override
            public void onSuccess(String url) {
                getView().onSuccess(url);
            }

            @Override
            public void onError(Throwable throwable) {
                getView().onError(throwable);
            }
        });
    }
}

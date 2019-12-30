package com.bawei.wangchu12242;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.bawei.adapter.MyAdapter;
import com.bawei.adapter.MyAdapter2;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.NewsBean;
import com.bawei.presenter.Presenter;
import com.bawei.url.MyUrl;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends BaseActivity {
    private List<NewsBean.CategoryBean> list = new ArrayList<>();
    private RecyclerView recy_aa;
    private RecyclerView recy_bb;
    private MyAdapter myAdapter;

    @Override
    protected void startcoming() {
        mPresenter.getNoPram(MyUrl.URL,NewsBean.class);
    }

    @Override
    protected BasePresenter initmPresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        recy_aa=findViewById(R.id.recy_aa);
        recy_bb=findViewById(R.id.recy_bb);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void onRuccess(Object v) {
        if (v instanceof NewsBean){
            myAdapter = new MyAdapter(list,this);
            recy_aa.setAdapter(myAdapter);
        }
    }

    @Override
    public void onError(String error) {

    }
}

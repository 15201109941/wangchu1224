package com.bawei.zuoye2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.UserBean;
import com.bawei.presenter.Presenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private List<UserBean.DataBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void startDing() {
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);
        mPresenter.getInfoParams("http://blog.zhaoliang5156.cn/api/shop/fulishe1.json");
        myAdapter.setItemClick(new MyAdapter.ItemClick() {
            @Override
            public void onClick(int s) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String url) {
        Gson gson = new Gson();
        UserBean userBean = gson.fromJson(url, UserBean.class);
        list.addAll(userBean.getData());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Throwable throwable) {

    }
}

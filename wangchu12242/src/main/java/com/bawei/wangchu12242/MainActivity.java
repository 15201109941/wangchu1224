package com.bawei.wangchu12242;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.LoginBean;
import com.bawei.md5.MD5Utils;
import com.bawei.presenter.Presenter;
import com.bawei.url.MyUrl;
import com.bawei.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {


    private EditText edit_a;
    private EditText edit_b;
    private Button btn_zhuce;
    private Button btn_denglu;
    private SharedPreferences sp;

    @Override
    protected void startcoming() {
        btn_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ZhuCeMain3Activity.class);
                startActivity(intent);
                finish();
            }
        });
        btn_denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MD5加密
                String md = MD5Utils.getMd5("MD5加密");
                Log.i("md5", "onClick: "+md);
                final String phone = edit_a.getText().toString().trim();
                if (TextUtils.isEmpty(phone)){
                    Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                }
                String pwd = edit_b.getText().toString().trim();
                if (TextUtils.isEmpty(pwd)){
                    Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                }
                Map<String,Object>map = new HashMap<>();
                map.put("phone",phone);
                map.put("pwd",pwd);
                HttpUtil.getInstance().postInfoPram(MyUrl.LOGIN, map, LoginBean.class, new HttpUtil.MyCallBack() {
                    @Override
                    public void onRuccess(Object v) {
                        if (v instanceof LoginBean&&((LoginBean) v).getStatus().equals("0000")){
                            sp.edit().putString("userId",((LoginBean) v).getResult().getUserId()+"").commit();
                            sp.edit().putString("sessionId",((LoginBean) v).getResult().getSessionId()+"").commit();
                            Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onError(String error) {

                    }
                });
            }
        });
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
        edit_a=findViewById(R.id.edit_a);
        edit_b=findViewById(R.id.edit_b);
        btn_zhuce=findViewById(R.id.btn_zhuce);
        btn_denglu=findViewById(R.id.btn_denglu);
        sp = getSharedPreferences("asd", MODE_PRIVATE);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onRuccess(Object v) {

    }

    @Override
    public void onError(String error) {

    }

}

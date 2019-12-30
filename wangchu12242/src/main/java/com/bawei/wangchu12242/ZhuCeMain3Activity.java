package com.bawei.wangchu12242;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.ZhuCeBean;
import com.bawei.presenter.Presenter;
import com.bawei.url.MyUrl;

import java.util.HashMap;
import java.util.Map;

public class ZhuCeMain3Activity extends BaseActivity {


    private EditText edit_a;
    private EditText edit_b;
    private Button btn_zhu;

    @Override
    protected void startcoming() {
        btn_zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edit_a.getText().toString().trim();
                if (TextUtils.isEmpty(phone)){
                    Toast.makeText(ZhuCeMain3Activity.this, "注册账号不能为空", Toast.LENGTH_SHORT).show();
                }
                String pwd = edit_b.getText().toString().trim();
                if (TextUtils.isEmpty(pwd)){
                    Toast.makeText(ZhuCeMain3Activity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
                Map<String,Object>map = new HashMap<>();
                map.put("phone",phone);
                map.put("pwd",pwd);
                mPresenter.postInfoPram(MyUrl.ZHUCE,map,ZhuCeBean.class);
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
        btn_zhu=findViewById(R.id.btn_zhu);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_zhu_ce_main3;
    }

    @Override
    public void onRuccess(Object v) {
        if (v instanceof ZhuCeBean){
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ZhuCeMain3Activity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onError(String error) {

    }

}

package com.bawei.fuxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.bawei.bean.News;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Even extends AppCompatActivity {

    @BindView(R.id.btn_a)
    Button btnA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_a)
    public void onViewClicked() {
        EventBus.getDefault().post("wada");
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    public void OnAt(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}

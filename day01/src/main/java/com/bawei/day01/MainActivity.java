package com.bawei.day01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView text_a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

                Toast.makeText(MainActivity.this, "{\"result\":[{\"imageUrl\":\"http://172.17.8.100/images/small/banner/cj.png\",\"jumpUrl\":\"http://172.17.8.100/htm/lottery/index.html\",\"rank\":5,\"title\":\"抽奖\"},{\"imageUrl\":\"http://172.17.8.100/images/small/banner/hzp.png\",\"jumpUrl\":\"wd://commodity_list?arg=1001007005\",\"rank\":5,\"title\":\"美妆工具\"},{\"imageUrl\":\"http://172.17.8.100/images/small/banner/lyq.png\",\"jumpUrl\":\"wd://commodity_info?arg=83\",\"rank\":5,\"title\":\"连衣裙\"},{\"imageUrl\":\"http://172.17.8.100/images/small/banner/px.png\",\"jumpUrl\":\"wd://commodity_info?arg=165\",\"rank\":5,\"title\":\"跑鞋\"},{\"imageUrl\":\"http://172.17.8.100/images/small/banner/wy.png\",\"jumpUrl\":\"wd://commodity_list?arg=1001002004\",\"rank\":5,\"title\":\"卫衣\"}],\"message\":\"查询成功\",\"status\":\"0000\"}", Toast.LENGTH_SHORT).show();

    }

    private void initView() {
        text_a=findViewById(R.id.text_a);
    }
}

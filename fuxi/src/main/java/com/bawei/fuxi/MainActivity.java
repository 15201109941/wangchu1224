package com.bawei.fuxi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @butterknife.BindView(R.id.text_a)
    TextView textA;
    @butterknife.BindView(R.id.rq_camera)
    Button rqCamera;
    @butterknife.BindView(R.id.rq_photos)
    Button rqPhotos;
    @butterknife.BindView(R.id.rq_image)
    ImageView rqImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.bind(this);
        CodeUtils.init(this);
        rqImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(rqImage, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(MainActivity.this, "成功"+result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });
        HttpUtil.getInstance().getJsonGet("http://blog.zhaoliang5156.cn/api/student/clazzstudent.json", new HttpUtil.MyCallBack() {
            @Override
            public void onGetJson(String json) {
                Toast.makeText(MainActivity.this, json, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable throwable) {
                Toast.makeText(MainActivity.this, "趣闻阿诗丹顿", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick({R.id.rq_image,R.id.rq_camera,R.id.rq_photos})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rq_image:
                String s = textA.getText().toString();
                Bitmap image = CodeUtils.createImage(s, 400, 400, null);
                rqImage.setImageBitmap(image);
            case R.id.rq_camera:
                CodeUtils.analyzeByCamera(this);;
                break;
            case R.id.rq_photos:
                CodeUtils.analyzeByPhotos(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CodeUtils.onActivityResult(this, requestCode, resultCode, data, new CodeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                Toast.makeText(MainActivity.this, "成功"+result, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnalyzeFailed() {
                Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

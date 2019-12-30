package com.bawei.asd;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.Open_Camera)
    Button OpenCamera;
    @BindView(R.id.Generate_Text)
    EditText GenerateText;
    @BindView(R.id.Generate_Btn)
    Button GenerateBtn;
    @BindView(R.id.My_Image)
    ImageView MyImage;
    @BindView(R.id.Get_Text)
    TextView GetText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CodeUtils.init(this);
        MyImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(MyImage, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(MainActivity.this,"失败",Toast.LENGTH_LONG).show();
                    }
                });
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Generate_Btn:
                String s = GenerateText.getText().toString();
                if (s.isEmpty()) {
                    Toast.makeText(MainActivity.this, "请输入信息", Toast.LENGTH_LONG).show();
                } else {
                    Bitmap image1 = CodeUtils.createImage(s, 500, 500, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                    MyImage.setImageBitmap(image1);
                }
            case R.id.Generate_Text:
                CodeUtils.analyzeByCamera(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CodeUtils.onActivityResult(this, requestCode, resultCode, data, new CodeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAnalyzeFailed() {
                Toast.makeText(MainActivity.this,"失败",Toast.LENGTH_LONG).show();
            }
        });
    }
}

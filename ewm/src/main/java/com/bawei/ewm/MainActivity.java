package com.bawei.ewm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_Camera)
    Button btnCamera;
    @BindView(R.id.text_a)
    EditText text_a;
    @BindView(R.id.btn_shengc)
    Button btnShengc;
    @BindView(R.id.img_a)
    ImageView img_a;
    @BindView(R.id.Get_Text)
    TextView Get_Text;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_Camera:
                CodeUtils.analyzeByCamera(this);
            case R.id.btn_shengc:
                CodeUtils.analyzeByPhotos(this);
        }
    }
}

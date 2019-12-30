package com.bawei.erweima;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.uuzuche.lib_zxing.activity.CaptureActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_a;
    private EditText Generate_Text;
    private Button Generate_Btn;
    private ImageView My_Image;
    private TextView Get_Text;
    private final int COME=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_a:
                Intent intent = new Intent(this, CaptureActivity.class);
                startActivityForResult(intent,COME);
                break;
        }
    }

    private void initView() {
        btn_a = (Button) findViewById(R.id.btn_a);
        Generate_Text = (EditText) findViewById(R.id.Generate_Text);
        Generate_Btn = (Button) findViewById(R.id.Generate_Btn);
        My_Image = (ImageView) findViewById(R.id.My_Image);
        Get_Text = (TextView) findViewById(R.id.Get_Text);

        btn_a.setOnClickListener(this);
        Generate_Btn.setOnClickListener(this);
    }

}

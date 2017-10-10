package com.cxria.rotateviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RotateView mRotateView;
    List<Integer> images=new ArrayList<>();
    List<String> names=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRotateView = (RotateView) findViewById(R.id.rv_rotateview);
        intDate();
        mRotateView.setImageIcon(images);
        mRotateView.setStrName(names);
        findViewById(R.id.iv_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //-1为随机数或者指定位置，但必须小于总个数
                mRotateView.startAnimation(-1);
            }
        });

        //获取到位置
        mRotateView.setOnCallBackPosition(new RotateView.onCallBackPosition() {
            @Override
            public void getStopPosition(int pos) {
                Toast.makeText(MainActivity.this, "位置："+names.get(pos), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void intDate() {
        images.add(R.mipmap.role);
        images.add(R.mipmap.sports);
        images.add(R.mipmap.words);
        images.add(R.mipmap.action);
        images.add(R.mipmap.combat);
        images.add(R.mipmap.moba);
        names= Arrays.asList(getResources().getStringArray(R.array.name));
    }
}

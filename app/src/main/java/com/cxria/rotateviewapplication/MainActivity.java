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
    private RotateView mRotateView2;

    List<Integer> images=new ArrayList<>();
    List<String> names=new ArrayList<>();
    private RotateLayoutView mRotateLayoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intDate();
        initRotate1();
        initRotate2();
        initRotate3();
    }



    //不同版本的View
    private void initRotate1() {
        mRotateView = (RotateView) findViewById(R.id.rv_rotateview);
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

    //不同版本的View
    private void initRotate2() {
        mRotateView2 = (RotateView) findViewById(R.id.rv_rotateview2);
        mRotateView2.setImageIcon(images);
        mRotateView2.setStrName(names);
        findViewById(R.id.iv_start2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //-1为随机数或者指定位置，但必须小于总个数
                mRotateView2.startAnimation(-1);
            }
        });
        //获取到位置
        mRotateView2.setOnCallBackPosition(new RotateView.onCallBackPosition() {
            @Override
            public void getStopPosition(int pos) {
                Toast.makeText(MainActivity.this, "位置："+names.get(pos), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //将两个自定义View变成一个了，方法上有点变化而已，其他的没有太大的变化
    private void initRotate3() {
        mRotateLayoutView = (RotateLayoutView) findViewById(R.id.rv_rotatelayoutview);
        mRotateLayoutView.setImageIcon(images);
        mRotateLayoutView.setStrName(names);

        mRotateLayoutView.setOnCallBackPosition(-1,new RotateLayoutView.onCallBackPosition() {
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

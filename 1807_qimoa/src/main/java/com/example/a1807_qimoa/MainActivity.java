package com.example.a1807_qimoa;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;

import com.example.a1807_qimoa.adapter.RecycAdapter;
import com.example.a1807_qimoa.bean.ArtBean;
import com.example.a1807_qimoa.mvp.MainView;
import com.example.a1807_qimoa.mvp.Mainpresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    private Toolbar mMyTool;
    private RecyclerView mMyRecyc;
    private RecycAdapter recycAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        new Mainpresenter(this).getInfo();

        recycAdapter.setA(new RecycAdapter.A() {
            @Override
            public void onClickListener(View view, int position) {

                CheckBox love = view.findViewById(R.id.love);
                boolean checked = love.isChecked();
                if (checked==true){
                    //添加进数据库
                    love.setText("取消");

                }else {
                    //删除数据库
                    love.setText("关注");
                }

            }
        });
    }


    private void initView() {
        mMyTool = (Toolbar) findViewById(R.id.myTool);
        mMyTool.setTitle("列表");
        setSupportActionBar(mMyTool);


        mMyRecyc = (RecyclerView) findViewById(R.id.myRecyc);
        mMyRecyc.setLayoutManager(new LinearLayoutManager(this));
        recycAdapter = new RecycAdapter(MainActivity.this);
        mMyRecyc.setAdapter(recycAdapter);
    }

    @Override
    public void onSuccess(ArtBean artBean) {

        List<ArtBean.DatasEntity> datas = artBean.getDatas();
        recycAdapter.initData(datas);

    }

    @Override
    public void onField(String a) {

    }
}

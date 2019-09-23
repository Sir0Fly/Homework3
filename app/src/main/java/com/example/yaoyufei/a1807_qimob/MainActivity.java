package com.example.yaoyufei.a1807_qimob;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.yaoyufei.a1807_qimob.presenter.Mainpresenter;
import com.example.yaoyufei.a1807_qimob.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView mMyRecyc;
    private RecycAdapter recycAdapter;
    private ViewPager mMyViewPager;
    private List<ArtBean.ResultsEntity> results=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Mainpresenter(this).getInfo();
        initView();

        recycAdapter.setA(new RecycAdapter.A() {
            @Override
            public void onClickListener(View view, int position) {
                initPager();
                mMyRecyc.setVisibility(View.INVISIBLE);
                mMyViewPager.setVisibility(View.VISIBLE);
               mMyViewPager.setCurrentItem(position);
            }
        });

    }

    private void initPager() {
        List<String> url=new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            String a = results.get(i).getUrl();
            url.add(a);
        }
        PagerAdapter pagerAdapter = new PagerAdapter(url,MainActivity.this);
        mMyViewPager.setAdapter(pagerAdapter);
        pagerAdapter.notifyDataSetChanged();
    }

    private void initView() {
        mMyRecyc = (RecyclerView) findViewById(R.id.myRecyc);
        mMyRecyc.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recycAdapter = new RecycAdapter(this);
        mMyRecyc.setAdapter(recycAdapter);
        mMyViewPager = (ViewPager) findViewById(R.id.myViewPager);
    }

    @Override
    public void onSuccess(ArtBean artBean) {
        results = artBean.getResults();
        recycAdapter.initData(results);
    }

    @Override
    public void onField(String a) {

    }
}

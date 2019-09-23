package com.example.yaoyufei.a1807_qimob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends android.support.v4.view.PagerAdapter {

    List<String> list=new ArrayList<>();
    Context context;

    public PagerAdapter(List<String> list,Context context) {
        this.list = list;
        this.context=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = View.inflate(context, R.layout.item_view, null);
        ImageView iv = view.findViewById(R.id.pager_iv);
        TextView tv = view.findViewById(R.id.pager_tv);
        tv.setText((position+1)+"/"+list.size());
        Glide.with(context).load(list.get(position)).placeholder(R.mipmap.ic_launcher).into(iv);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }
}

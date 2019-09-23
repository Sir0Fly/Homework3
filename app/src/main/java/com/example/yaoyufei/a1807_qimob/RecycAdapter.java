package com.example.yaoyufei.a1807_qimob;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.ViewHolder> {

   List<ArtBean.ResultsEntity> list=new ArrayList<>();
    Context context;

    public RecycAdapter(Context context) {
        this.context = context;
    }

    public void initData(List<ArtBean.ResultsEntity> list){

        this.list=list;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_pic, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        Glide.with(context).load(list.get(i).getUrl()).placeholder(R.mipmap.ic_launcher).into(viewHolder.iv);

       viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               a.onClickListener(v,i);
               return false;
           }
       });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            //获取屏幕默认宽
            int width = ((Activity) iv.getContext()).getWindowManager().getDefaultDisplay().getWidth();
            //获取控件布局参数
            ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
            //设置宽高
            layoutParams.width=width/2;
            layoutParams.height= (int) (300+Math.random()*400);
            //给空间设置慧参数
            iv.setLayoutParams(layoutParams);

        }
    }

    //接口回调

    private A a;

    public void setA(A a) {
        this.a = a;
    }

    public interface A{
        void onClickListener(View view,int position);
    }
}

package com.example.a1807_qimoa.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.a1807_qimoa.R;
import com.example.a1807_qimoa.bean.ArtBean;

import java.util.ArrayList;
import java.util.List;

public class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.ViewHolder> {

    List<ArtBean.DatasEntity> list=new ArrayList<>();
    Context context;

    public RecycAdapter(Context context) {
        this.context = context;
    }
    public void initData(List<ArtBean.DatasEntity> list){
        this.list=list;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_topic, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {


        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(context).load(list.get(i).getThumbnail()).placeholder(R.mipmap.ic_launcher).apply(requestOptions).into(viewHolder.item_iv);
        viewHolder.topic.setText(list.get(i).getTitle());
        viewHolder.desc.setText(list.get(i).getAuthor());

        viewHolder.love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.onClickListener(v,i);
            }
        });
        //查询数据库，与list比较，有：先获取list下标 ，当position==下表式，设置love为checked==true

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView item_iv;
        TextView topic;
        TextView desc;
        CheckBox love;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_iv = itemView.findViewById(R.id.item_iv);
            topic = itemView.findViewById(R.id.topic);
            desc = itemView.findViewById(R.id.desc);
            love = itemView.findViewById(R.id.love);

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

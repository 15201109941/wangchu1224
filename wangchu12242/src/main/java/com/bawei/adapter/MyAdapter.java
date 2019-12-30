package com.bawei.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.bean.NewsBean;
import com.bawei.wangchu12242.R;

import java.util.List;

/*
 *@auther:王楚
 *@Date: 2019/12/24
 *@Time:15:02
 *@Description:${DESCRIPTION}
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private List<NewsBean.CategoryBean> list;
    private Context context;

    public MyAdapter(List<NewsBean.CategoryBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.a, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.Holder holder, int i) {
        if (list.size()>=0){
            holder.text_a.setText(list.get(i).getClazz());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView text_a;
        public Holder(@NonNull View itemView) {
            super(itemView);
            text_a=itemView.findViewById(R.id.text_a);
        }
    }
}

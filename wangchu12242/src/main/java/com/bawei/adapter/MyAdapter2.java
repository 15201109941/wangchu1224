package com.bawei.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.bean.NewsBean;
import com.bawei.util.GlideUtil;
import com.bawei.wangchu12242.R;
import com.bumptech.glide.Glide;

import java.util.List;
import java.util.logging.Handler;

/*
 *@auther:王楚
 *@Date: 2019/12/24
 *@Time:15:07
 *@Description:${DESCRIPTION}
 **/
public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.Holder> {
    private List<NewsBean.CategoryBean.ChildsBean> list;
    private Context context;

    public MyAdapter2(List<NewsBean.CategoryBean.ChildsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter2.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.aa, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.Holder holder, int i) {
        if (list.size()>=0){
            holder.text_aa.setText(list.get(i).getName());
            GlideUtil.LoadImage(list.get(i).getAvatar(), holder.img_a);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView img_a;
        private TextView text_aa;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img_a=itemView.findViewById(R.id.img_a);
            text_aa=itemView.findViewById(R.id.text_aa);
        }
    }
}

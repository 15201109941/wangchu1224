package com.bawei.adapter;

/*
 *@auther:王楚
 *@Date: 2019/12/29
 *@Time:20:28
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.bean.UserBean;
import com.bawei.util.GlideUtil;
import com.bawei.util.HttpUtil;
import com.bawei.zuoye2.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private  Context context;
    private List<UserBean.DataBean> list;

    public MyAdapter(Context context, List<UserBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.Holder holder, final int i) {
        holder.name.setText(list.get(i).getGoods_name());
        GlideUtil.loadImage(list.get(i).getGoods_thumb(), holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface ItemClick{
        void onClick(int s);
    }
    private ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }
    public class Holder extends RecyclerView.ViewHolder {
         TextView name;
         ImageView image;
        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
        }
    }
}


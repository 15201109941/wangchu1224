package com.bawei.util;

import android.widget.ImageView;

import com.bawei.app.MyApp;
import com.bawei.zuoye2.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

/*
 *@auther:王楚
 *@Date: 2019/12/29
 *@Time:20:10
 *@Description:${DESCRIPTION}
 **/
public class GlideUtil {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }
}

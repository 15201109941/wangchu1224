package com.bawei.util;

import android.widget.ImageView;

import com.bawei.app.MyApp;
import com.bawei.zuoye.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/*
 *@auther:王楚
 *@Date: 2019/12/29
 *@Time:19:12
 *@Description:${DESCRIPTION}
 **/
public class GlideUtil {
    public static void loadImage(String str, ImageView imageView){
        Glide.with(MyApp.context).load(str)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                .into(imageView);
    }
}

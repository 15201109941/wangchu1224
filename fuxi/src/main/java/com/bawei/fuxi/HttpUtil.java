package com.bawei.fuxi;

import android.os.Handler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
 *@auther:王楚
 *@Date: 2019/12/27
 *@Time:19:12
 *@Description:${DESCRIPTION}
 **/
public class HttpUtil {
    private static HttpUtil httpUtil;
    private Handler handler;
    private final OkHttpClient okHttpClient;

    private HttpUtil() {
        handler = new Handler();
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();
//        okHttpClient = new OkHttpClient();
//        this.okHttpClient.newBuilder()
//                .readTimeout(5, TimeUnit.SECONDS)
//                .writeTimeout(5, TimeUnit.SECONDS)
//                .connectTimeout(5, TimeUnit.SECONDS)
//                .build();
    }

    public static HttpUtil getInstance() {
        if(httpUtil==null){
            synchronized (HttpUtil.class){
                if(httpUtil==null){
                    httpUtil = new HttpUtil();
                }
            }
        }
        return httpUtil;
    }
    public void getJsonGet(String httpUrl, final MyCallBack myCallBack){
        Request build = new Request.Builder()
                .get()
                .url(httpUrl)
                .build();
        Call call = okHttpClient.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myCallBack.onError(e);
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null&&response.isSuccessful()) {
                    final String string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallBack.onGetJson(string);
                        }
                    });
                }else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallBack.onError(new Exception("失败"));
                        }
                    });
                }
            }
        });
    }
    public interface MyCallBack{
        void onGetJson(String json);
        void onError(Throwable throwable);
    }
}

package com.bawei.util;

import com.bawei.api.ApiService;
import com.bawei.url.MyUrl;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@auther:王楚
 *@Date: 2019/12/30
 *@Time:8:43
 *@Description:${DESCRIPTION}
 **/
public class HttpUtil {
    private ApiService apiService;
    private HttpUtil(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyUrl.URL)
                .client(okHttpClient)
                //结合Rxjava使用
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //结合Gson使用
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }
    private static class NetHolder{
        private static final HttpUtil mNet = new HttpUtil();
    }
    public static HttpUtil getInstance(){
        return NetHolder.mNet;
    }

    public interface MyCallBack<T>{
        void onRuccess(String url);
        void onError(String error);
    }
}

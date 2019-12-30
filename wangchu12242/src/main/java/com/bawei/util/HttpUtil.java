package com.bawei.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.TokenWatcher;
import android.text.TextUtils;

import com.bawei.api.ApiService;
import com.bawei.app.MyApp;
import com.bawei.url.MyUrl;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@auther:王楚
 *@Date: 2019/12/24
 *@Time:13:56
 *@Description:${DESCRIPTION}
 **/
public class HttpUtil {
    private ApiService apiService;
    private HttpUtil(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        SharedPreferences asd = MyApp.context.getSharedPreferences("asd", Context.MODE_PRIVATE);
                        String userId = asd.getString("userId", "");
                        String sessionId = asd.getString("sessionId", "");
                        if (TextUtils.isEmpty(userId)||TextUtils.isEmpty(sessionId)){
                            asd.getString("userId",userId);
                            asd.getString("sessionId",sessionId);
                            return chain.proceed(chain.request());
                        }else {
                            Request build = chain.request().newBuilder()
                                    .addHeader("userId", userId)
                                    .addHeader("sessionId", sessionId)
                                    .build();
                            return chain.proceed(build);
                        }
                    }
                })
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyUrl.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        apiService=retrofit.create(ApiService.class);
    }
    private static class NetHolder{
        private static final HttpUtil mNet = new HttpUtil();
    }
    public static HttpUtil getInstance(){
        return NetHolder.mNet;
    }
    public void getNoPram(String url, final Class cls, final MyCallBack myCallBack){
        apiService.getNoPram(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            if (myCallBack!=null){
                                myCallBack.onRuccess(o);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void getInfoPram(String url, Map<String,Object>map, final Class cls, final MyCallBack myCallBack){
        apiService.getInfoPram(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        if (myCallBack!=null){
                            Gson gson = new Gson();
                            try {
                                Object o = gson.fromJson(responseBody.string(), cls);
                                myCallBack.onRuccess(o);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void postInfoPram(String url, Map<String,Object>map, final Class cls, final MyCallBack myCallBack){
        apiService.postInfoPram(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        if (myCallBack!=null){
                            Gson gson = new Gson();
                            try {
                                Object o = gson.fromJson(responseBody.string(), cls);
                                myCallBack.onRuccess(o);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface MyCallBack<T>{
        void onRuccess(T v);
        void onError(String error);
    }
}

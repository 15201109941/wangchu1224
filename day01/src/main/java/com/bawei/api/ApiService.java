package com.bawei.api;

import android.database.Observable;

import java.util.Map;

import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/*
 *@auther:王楚
 *@Date: 2019/12/30
 *@Time:8:41
 *@Description:${DESCRIPTION}
 **/
public interface ApiService {
    @GET
    Observable<ResponseBody> getNoPram(@Url String url);

    @GET
    Observable<ResponseBody> getInfoPram(@Url String url, @QueryMap Map<String, Object> map);

}

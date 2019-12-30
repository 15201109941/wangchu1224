package com.bawei.api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/*
 *@auther:王楚
 *@Date: 2019/12/24
 *@Time:13:47
 *@Description:${DESCRIPTION}
 **/
public interface ApiService {
    @GET
    Observable<ResponseBody> getNoPram(@Url String url);
    @GET
    Observable<ResponseBody> getInfoPram(@Url String url,@QueryMap Map<String,Object>map);
    @POST
    Observable<ResponseBody> postInfoPram(@Url String url,@QueryMap Map<String,Object>map);
}

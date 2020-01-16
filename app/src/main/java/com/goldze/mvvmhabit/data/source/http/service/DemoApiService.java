package com.goldze.mvvmhabit.data.source.http.service;

import com.goldze.mvvmhabit.entity.DemoEntity;
import com.goldze.mvvmhabit.request.LoginReq;
import com.goldze.mvvmhabit.response.BuyInfoRes;
import com.goldze.mvvmhabit.response.LoginRes;

import java.util.Map;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by goldze on 2017/6/15.
 */

public interface DemoApiService {
    @GET("action/apiv2/banner?catalog=1")
    Observable<BaseResponse<DemoEntity>> demoGet();

    @FormUrlEncoded
    @POST("action/apiv2/banner")
    Observable<BaseResponse<DemoEntity>> demoPost(@Field("catalog") String catalog);

    @Headers("Content-Type: application/json")
    @POST("login")
    Observable<BaseResponse<LoginRes>> loginPost(@Body LoginReq loginReq);

    @Headers("Content-Type: application/json")
    @GET("protected")
    Observable<BaseResponse> getLoginName();

    @Headers("Content-Type: application/json")
    @POST("getAllnoSell")
    Observable<BaseResponse<BuyInfoRes>> getBuyResult(@Body Map<String, Object> params);

    @Headers("Content-Type: application/json")
    @GET("protected-fresh")
    Call<String> getLoginNameTest();
}

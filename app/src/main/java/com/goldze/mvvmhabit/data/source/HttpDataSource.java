package com.goldze.mvvmhabit.data.source;

import com.goldze.mvvmhabit.entity.DemoEntity;
import com.goldze.mvvmhabit.response.BuyInfoRes;
import com.goldze.mvvmhabit.response.LoginRes;

import java.util.List;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * Created by goldze on 2019/3/26.
 */
public interface HttpDataSource {
    //模拟登录
    Observable<BaseResponse<LoginRes>> login(String username, String password);
    //获取登录名
    Observable<BaseResponse> getLoginName();

    //获取购买信息
    Observable<BaseResponse<BuyInfoRes>> getBuyInfo(String symbol);

    //模拟上拉加载
    Observable<DemoEntity> loadMore();

    Observable<BaseResponse<DemoEntity>> demoGet();

    Observable<BaseResponse<DemoEntity>> demoPost(String catalog);


}

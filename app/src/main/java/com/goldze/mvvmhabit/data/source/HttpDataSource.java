package com.goldze.mvvmhabit.data.source;

import com.goldze.mvvmhabit.entity.DemoEntity;
import com.goldze.mvvmhabit.entity.LoginEntity;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * Created by goldze on 2019/3/26.
 */
public interface HttpDataSource {
    //模拟登录
    Observable<BaseResponse<LoginEntity>> login(String username, String password);

    //模拟上拉加载
    Observable<DemoEntity> loadMore();

    Observable<BaseResponse<DemoEntity>> demoGet();

    Observable<BaseResponse<DemoEntity>> demoPost(String catalog);


}

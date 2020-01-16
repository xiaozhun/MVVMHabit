package com.goldze.mvvmhabit;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.data.source.HttpDataSource;
import com.goldze.mvvmhabit.data.source.LocalDataSource;
import com.goldze.mvvmhabit.data.source.http.HttpDataSourceImpl;
import com.goldze.mvvmhabit.data.source.http.service.DemoApiService;
import com.goldze.mvvmhabit.data.source.local.LocalDataSourceImpl;
import com.goldze.mvvmhabit.utils.RetrofitClient;

import org.junit.Before;
import org.junit.Test;

import me.goldze.mvvmhabit.utils.KLog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {

    }
}
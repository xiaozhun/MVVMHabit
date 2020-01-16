package com.goldze.mvvmhabit;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.goldze.mvvmhabit.data.source.http.service.DemoApiService;
import com.goldze.mvvmhabit.utils.RetrofitClient;

import org.junit.Test;
import org.junit.runner.RunWith;

import me.goldze.mvvmhabit.utils.KLog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
//        assertEquals("com.goldze.mvvmhabit", appContext.getPackageName());
        RetrofitClient retrofitClient =RetrofitClient.getInstance();
        DemoApiService demoApiService = retrofitClient.create(DemoApiService.class);
        KLog.d(demoApiService.getLoginNameTest());
        Call<String> repos = demoApiService.getLoginNameTest();
        repos.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                KLog.d("执行到此");
                KLog.e(response);
                KLog.d(call);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                KLog.d(call);
            }
        });
        try {
            //睡眠10s
            KLog.d("睡眠开始");
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

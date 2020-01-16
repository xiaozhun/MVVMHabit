package com.goldze.mvvmhabit.ui.tab_bar.vm;

import android.app.Application;
import android.arch.lifecycle.Observer;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.data.source.http.service.DemoApiService;
import com.goldze.mvvmhabit.entity.BuyInfoEntity;
import com.goldze.mvvmhabit.response.BuyInfoRes;
import com.goldze.mvvmhabit.ui.login.LoginViewModel;
import com.goldze.mvvmhabit.utils.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.bus.Messenger;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.http.BaseResponse;
import me.goldze.mvvmhabit.utils.KLog;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 所有例子仅做参考,千万不要把它当成一种标准,毕竟主打的不是例子,业务场景繁多,理解如何使用才最重要。
 * Created by goldze on 2018/7/18.
 */

public class BuyinfoRecyclerViewModel extends BaseViewModel<DemoRepository> {
    public ObservableField<String> alltradesnum=new ObservableField<>("");
    public ObservableField<String> notsellnum=new ObservableField<>("");
    public ObservableField<String> sumprofit=new ObservableField<>("");
    public ObservableField<String> nowprice=new ObservableField<>("");
    public static final String PAPER_MOVE= "MOVE";
    //封装一个界面发生改变的观察者
    public BuyinfoRecyclerViewModel.UIChangeObservable uc = new BuyinfoRecyclerViewModel.UIChangeObservable();
    public class UIChangeObservable {
        //下拉刷新完成
        public SingleLiveEvent finishRefreshing = new SingleLiveEvent<>();
        //上拉加载完成
        public SingleLiveEvent finishLoadmore = new SingleLiveEvent<>();
    }

    public BuyinfoRecyclerViewModel(@NonNull Application application, DemoRepository repository) {
        super(application,repository);
        KLog.d("执行到初始化数据");
        try {
            initBuyinfo(application);
        } catch (Exception e) { // NOPMD
            KLog.e("请求数据异常");
            KLog.e(e.getMessage());
        }
        //注册监听
        Messenger.getDefault().register(this, BuyinfoRecyclerViewModel.PAPER_MOVE, String.class, new BindingConsumer<String>() {
            @Override
            public void call(String s) {
                KLog.d("00000000000000"+s);
            }
        });
    }
    //给RecyclerView添加ObservableList
    public ObservableList<BuyInfoItemViewModel> observableList = new ObservableArrayList<>();
    //给ViewPager添加ItemBinding
    public ItemBinding<BuyInfoItemViewModel> itemBinding = ItemBinding.of(com.goldze.mvvmhabit.BR.viewModel, R.layout.buyinfo_recyclerview);
    //下拉刷新
    public BindingCommand onRefreshCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ToastUtils.showShort("下拉刷新");
        }
    });
    //上拉加载
    public BindingCommand onLoadMoreCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ToastUtils.showShort("上拉加载");
        }
    });
    public BindingCommand onItemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //点击之后将逻辑转到activity中处理
            observableList.clear();
            try {
                initBuyinfo(getApplication());
            } catch (Exception e) { // NOPMD
                KLog.e("请求数据异常");
                KLog.e(e.getMessage());
            }
        }
    });
    private void initBuyinfo(Application application){
        addSubscribe(model.getBuyInfo("btcusdt")
                .compose(RxUtils.schedulersTransformer()) //线程调度
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
//                        showDialog();
                    }
                }).subscribe(new Consumer<BaseResponse<BuyInfoRes>>() {
                    @Override
                    public void accept(BaseResponse<BuyInfoRes> buyInfoResResponse){
//                        dismissDialog();
                        KLog.d(buyInfoResResponse.getMessage());
                        if(!buyInfoResResponse.isOk()){
                            showDialog("数据获取失败");
                        }else{
                            //数量赋值
                            alltradesnum.set(buyInfoResResponse.getResult().getAlltradesnum());
                            sumprofit.set(buyInfoResResponse.getResult().getSumprofit());
                            notsellnum.set(buyInfoResResponse.getResult().getNotsellnum());
                            nowprice.set(buyInfoResResponse.getResult().getNowprice());
                            List<BuyInfoEntity> entityList = buyInfoResResponse.getResult().getData();
                            for(BuyInfoEntity buyInfoEntity :entityList){
                                observableList.add(new BuyInfoItemViewModel(application,buyInfoEntity));
                            }
                        }
                    }
                }));
    }

}

package com.goldze.mvvmhabit.ui.tab_bar.vm;

import android.app.Application;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.app.AppViewModelFactory;
import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.ui.login.LoginViewModel;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.BindingViewPagerAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * 所有例子仅做参考,千万不要把它当成一种标准,毕竟主打的不是例子,业务场景繁多,理解如何使用才最重要。
 * Created by goldze on 2018/7/18.
 */

public class TabBarAppsViewModel extends BaseViewModel {
    public SingleLiveEvent<String> itemClickEvent = new SingleLiveEvent<>();
    public TabBarAppsViewModel(@NonNull Application application) {
        super(application);
        //模拟3个ViewPager页面
//        for (int i = 1; i <= 3; i++) {
//            BuyinfoRecyclerViewModel itemViewModel = new BuyinfoRecyclerViewModel(application,demoRepository);
//            items.add(itemViewModel);
//        }
        AppViewModelFactory factory = AppViewModelFactory.getInstance(application);
        items.add(factory.create(BuyinfoRecyclerViewModel.class));
    }

    //给ViewPager添加ObservableList
    public ObservableList<BuyinfoRecyclerViewModel> items = new ObservableArrayList<>();
    //给ViewPager添加ItemBinding
    public ItemBinding<BuyinfoRecyclerViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.buyinfo_viewpager);
    //给ViewPager添加PageTitle
    public final BindingViewPagerAdapter.PageTitles<BuyinfoRecyclerViewModel> pageTitles = new BindingViewPagerAdapter.PageTitles<BuyinfoRecyclerViewModel>() {
        @Override
        public CharSequence getPageTitle(int position, BuyinfoRecyclerViewModel item) {
            return "条目" + position;
        }
    };
    //ViewPager切换监听
    public BindingCommand<Integer> onPageSelectedCommand = new BindingCommand<>(new BindingConsumer<Integer>() {
        @Override
        public void call(Integer index) {
            ToastUtils.showShort("ViewPager切换：" + index);
        }
    });
}

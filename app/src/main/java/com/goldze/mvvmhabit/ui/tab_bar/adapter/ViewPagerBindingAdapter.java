package com.goldze.mvvmhabit.ui.tab_bar.adapter;

import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

import com.goldze.mvvmhabit.databinding.BuyinfoRecyclerviewBinding;
import com.goldze.mvvmhabit.ui.tab_bar.vm.BuyinfoRecyclerViewModel;

import me.tatarka.bindingcollectionadapter2.BindingViewPagerAdapter;

/**
 * Created by goldze on 2018/6/21.
 */

public class ViewPagerBindingAdapter extends BindingViewPagerAdapter<BuyinfoRecyclerViewModel> {

    @Override
    public void onBindBinding(final ViewDataBinding binding, int variableId, int layoutRes, final int position, BuyinfoRecyclerViewModel item) {
        super.onBindBinding(binding, variableId, layoutRes, position, item);
        //这里可以强转成ViewPagerItemViewModel对应的ViewDataBinding，
        BuyinfoRecyclerviewBinding _binding = (BuyinfoRecyclerviewBinding) binding;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}

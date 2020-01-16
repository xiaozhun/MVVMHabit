package com.goldze.mvvmhabit.ui.tab_bar.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.goldze.mvvmhabit.entity.BuyInfoEntity;
import com.goldze.mvvmhabit.response.BuyInfoRes;


import me.goldze.mvvmhabit.base.BaseViewModel;

public class BuyInfoItemViewModel extends BaseViewModel{
    public ObservableField<BuyInfoEntity> observableField = new ObservableField<>();


    public BuyInfoItemViewModel(@NonNull Application application, BuyInfoEntity buyInfoEntity) {
        super(application);
        observableField.set(buyInfoEntity);
    }
}

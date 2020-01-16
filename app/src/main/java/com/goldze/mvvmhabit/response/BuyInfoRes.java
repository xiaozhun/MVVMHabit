package com.goldze.mvvmhabit.response;

import com.goldze.mvvmhabit.entity.BuyInfoEntity;

import java.util.List;

public class BuyInfoRes {
    private String alltradesnum;//所有购买数量
    private String notsellnum;//未出售数量
    private String sumprofit;//当前利润
    private String nowprice;//当前价格
    private List<BuyInfoEntity> data;

    public String getNowprice() {
        return nowprice;
    }

    public void setNowprice(String nowprice) {
        this.nowprice = nowprice;
    }

    public String getAlltradesnum() {
        return alltradesnum;
    }

    public void setAlltradesnum(String alltradesnum) {
        this.alltradesnum = alltradesnum;
    }

    public String getNotsellnum() {
        return notsellnum;
    }

    public void setNotsellnum(String notsellnum) {
        this.notsellnum = notsellnum;
    }

    public String getSumprofit() {
        return sumprofit;
    }

    public void setSumprofit(String sumprofit) {
        this.sumprofit = sumprofit;
    }

    public List<BuyInfoEntity> getData() {
        return data;
    }

    public void setData(List<BuyInfoEntity> data) {
        this.data = data;
    }
}

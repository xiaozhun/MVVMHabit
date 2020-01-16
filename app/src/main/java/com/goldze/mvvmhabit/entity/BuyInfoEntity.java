package com.goldze.mvvmhabit.entity;

import lombok.Data;

//@Data
public class BuyInfoEntity {
    private String buydate; //购买时间
    private String buyprice;//购买价格
    private String presellprice;//预卖出价格
    private String nowprofit;//当前利润

    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }

    public String getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(String buyprice) {
        this.buyprice = buyprice;
    }

    public String getPresellprice() {
        return presellprice;
    }

    public void setPresellprice(String presellprice) {
        this.presellprice = presellprice;
    }

    public String getNowprofit() {
        return nowprofit;
    }

    public void setNowprofit(String nowprofit) {
        this.nowprofit = nowprofit;
    }
}

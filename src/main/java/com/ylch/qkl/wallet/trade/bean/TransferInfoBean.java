package com.ylch.qkl.wallet.trade.bean;

import java.math.BigInteger;

/**
 * Created by ylch on 2018/8/14.
 */
public class TransferInfoBean {
    private String FromAccount;
    private String ToAccount;
    private BigInteger value;
    private String data;
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public String getFromAccount() {
        return FromAccount;
    }

    public void setFromAccount(String fromAccount) {
        FromAccount = fromAccount;
    }

    public String getToAccount() {
        return ToAccount;
    }

    public void setToAccount(String toAccount) {
        ToAccount = toAccount;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

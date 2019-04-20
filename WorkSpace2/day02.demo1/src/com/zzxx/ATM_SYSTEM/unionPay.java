package com.zzxx.ATM_SYSTEM;

abstract class unionPay {
    public double money = 0.0;
    public String pwd;
    public unionPay(double money, String password) {
        this.money = money;
        this.pwd = password;

    }
    public abstract void getBalance();
    public abstract void drawMoney(double money);
    public abstract void checkPwd(String passWord);
}

interface ICBCOnlinePay {
    void  onlinePay(double money);
}
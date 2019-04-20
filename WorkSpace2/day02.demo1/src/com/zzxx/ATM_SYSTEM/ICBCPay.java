package com.zzxx.ATM_SYSTEM;
import com.zzxx.ATM_SYSTEM.unionPay;

public class ICBCPay extends unionPay implements ICBCOnlinePay{

    public ICBCPay(double money, String password) {
        super(money, password);

    }

    @Override
    public void getBalance() {
        System.out.println(this.money);

    }

    @Override
    public void drawMoney(double money) {

        if (this.money - 200 < money) {
            System.out.println("余额不足！");

        } else {
            System.out.println("取款成功，账户余额为" + (this.money - money));
            this.money -= money;

        }
    }

    @Override
    public void checkPwd(String passWord) {
        if (passWord.equals(this.pwd)) {
            System.out.println("Passed");

        } else {
            System.out.println("Wrong!");

        }

    }

    @Override
    public void onlinePay(double money) {

        if (this.money + 200 < money) {
            System.out.println("余额不足！");

        } else {
            System.out.println("支付成功，账户余额为" + (this.money - money));
            this.money -= money;

        }
    }
}

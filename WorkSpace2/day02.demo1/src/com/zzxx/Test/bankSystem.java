package com.zzxx.Test;
import java.util.Date;
import java.util.Scanner;

public class bankSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入单价（￥）：");
        double price = scan.nextDouble();
        System.out.println("请输入数量：");
        int num = scan.nextInt();
        System.out.println("请输入金额（￥）：");
        double money = scan.nextDouble();

        if (price * num > money) {
            System.out.println("输入信息有误！");
        } else if (price * num >= 500) {
            System.out.print("应收金额：￥" + (double)(price * num * 0.8));
            System.out.println("," + "找零为：￥" + (double)(money - price * num * 0.8));
        } else {
            System.out.print("应收金额：￥" + (double)(price * num));
            System.out.println("," + "找零为：￥" + (double)(money - price * num));
        }
    }
}

package com.zzxx.Test;
import java.util.Scanner;

public class numberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number ;
        int goal = (int)(Math.random() * 1000 + 1);
        //System.out.println(goal);
        do {
            System.out.println("请输入你猜的数字:");
            number = scan.nextInt();

            if (number > goal) {
                System.out.println("太大了!");

            }
            if (number < goal) {
                System.out.println("太小了!");

            }


        } while (goal != number);
        System.out.println("你猜对了！");

    }
}

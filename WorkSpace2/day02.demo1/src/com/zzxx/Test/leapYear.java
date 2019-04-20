package com.zzxx.Test;
import java.util.Scanner;

public class leapYear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = scan.nextInt();

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("该年是闰年");
        } else {
            System.out.println("该年是平年");
        }

    }
}

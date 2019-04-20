/*
    题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
    小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月
    的兔子总数为多少？

    输入参数：经过的月份（Int）
    返回参数：兔子的总数量（Int）
*/

package com.zzxx.exercise;
import java.util.Scanner;

public class Solution01 {
    public static void main(String[] args) {
        int month = 0;
        Scanner scan = new Scanner(System.in); //输入经过的月份

        System.out.println("Please enter your month:");
        if (scan.hasNextInt()) {
            month = scan.nextInt();

        }
        System.out.println(rabbitSum(month) << 1);
    }
    public static int rabbitSum(int month) {
        if (month == 1 || month == 2) {   //新生的兔子前两个月不会生兔子
            return 1;

        } else {
            return rabbitSum(month - 1) + rabbitSum(month - 2);  //每一个月的兔子的数量等于上一个月的兔子总量和上上个月生的兔子的总量

        }
    }
}

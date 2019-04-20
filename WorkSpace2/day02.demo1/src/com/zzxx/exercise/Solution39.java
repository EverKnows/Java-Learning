/*
    题目：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n
    ,当输入n为奇数时，调用函数1/1+1/3+...+1/n
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution39 {
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));
        int n = scan.nextInt();
        System.out.println("结果是" + cacuSer(n));

    }
    private static double cacuSer(int n) {
        double sum = 0.0;

        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                sum = sum + (double)1 / (2 * i + 2);
            }

        } else {
            for (int i = 0; i < (n + 1) / 2; i++) {
                sum = sum + (double)1 / (2 * i + 1);
            }

        }
        return sum;
    }
}

/*
    题目：一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。
    例如6=1＋2＋3.编程     找出1000以内的所有完数。
 */
package com.zzxx.exercise;

public class Solution09 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 1001; ++ i) {
            for (int j = 1; j < i; ++ j) {
                if (i % j == 0) {
                    sum = sum + j;
                }
            }
            if (i == sum) {
                System.out.println(i);

            }
            sum = 0;

        }
    }
}

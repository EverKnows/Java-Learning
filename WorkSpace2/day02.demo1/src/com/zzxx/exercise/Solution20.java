/*
    题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
 */
package com.zzxx.exercise;

public class Solution20 {
    public static void main(String[] args) {
        double sum = 0.0;
        for (int i = 0; i < 20; i++) {
            sum = sum + (2 + i) / (i + 1);
        }
        System.out.println(sum);
    }
}

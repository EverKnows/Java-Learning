/*
    题目：求1+2!+3!+...+20!的和
 */
package com.zzxx.exercise;

public class Solution21 {
    public static void main(String[] args) {
        int sum = 0;
        int multi = 1;

        for (int i = 1; i <= 4; ++i) {
            for (int j = 1; j <= i ; ++j) {
                multi = multi * j;
            }
            sum = sum + multi;
            multi = 1;
        }
        System.out.println(sum);
    }
}

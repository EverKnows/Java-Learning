/*
题目：利用递归方法求5!。 
 */
package com.zzxx.exercise;

public class Solution22 {
    public static void main(String[] args) {
        System.out.println(cacuFactorial(5));
    }
    private static int cacuFactorial(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i * cacuFactorial(i - 1);
        }
    }
}

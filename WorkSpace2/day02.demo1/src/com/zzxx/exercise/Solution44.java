/*
    题目：5文钱买一只公鸡，3文钱买一只母鸡，1文钱可以买3只小鸡，
    现在要用100文钱买100只鸡，那么各有公鸡，母鸡，小鸡多少只？
 */
package com.zzxx.exercise;
import com.zzxx.exercise.Solution36;

public class Solution44 {
    public static void main(String[] args) {
        double cost = 0.0;
        int sum = 0;

        for (int i = 1; i <= 22; i++) {
            for (int j = 1; j <= 25; j++) {
                for (int k = 1; k <=100 ; k++) {
                    cost = 5 * i + 3 * j + k / (double)3;
                    sum = i + j + k ;
                    if (sum == 100 && cost == 100.0) {
                        System.out.println(i + " " + j + " " + k);
                    }
                }

            }
        }
    }
}

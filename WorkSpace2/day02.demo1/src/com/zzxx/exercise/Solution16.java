/*
    题目：输出9*9口诀。
 */
package com.zzxx.exercise;

public class Solution16 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; ++i) {
            for (int j = i; j <= 9; ++j) {
                System.out.print(i + "*" + j + "=" + (i * j) + ";" + " ");
            }
            System.out.println('\n');

        }
    }
}

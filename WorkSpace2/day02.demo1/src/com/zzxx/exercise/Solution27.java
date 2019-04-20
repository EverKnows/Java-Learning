/*
    题目：求100之内的素数(1是不是素数?)
 */
package com.zzxx.exercise;

public class Solution27 {
    public static void main(String[] args) {
        int mark = 1;
        for (int i = 1; i <= 100; ++i) {
            if (i % 2 == 0) {
                continue;

            } else {
                for (int j = 2; j <= (int)Math.sqrt(i) ; ++j) {
                    if (i % j == 0) {
                        mark = 0;
                    }
                }
                if (mark == 1) {
                    System.out.println(i);

                }
                mark = 1;
            }
        }
    }
}

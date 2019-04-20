/*
    题目：有1、2、3、4四个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 */
package com.zzxx.exercise;

public class Solution11 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (j != i) {
                    for (int k = 0; k < 4; ++k) {
                        if (k != j && k != i) {
                            System.out.print(i + 1);
                            System.out.print(j + 1);
                            System.out.println(k + 1);
                            ++sum;
                        }

                    }

                }

            }

        }
        System.out.println("排序的组合一共有" + sum + "种");

    }
}

/*
    题目：判断101-200之间有多少个素数，并输出所有素数。
    程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除， 则表明此数不是素数，反之是素数。
 */
package com.zzxx.exercise;

public class Solution02 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 0, j = 0;

        for (i = 101; i < 201; ++i) {
            for (j = 2; j <= (int)Math.sqrt(i); ++j) {
                if (i % j == 0) {
                    break;

                }

            }
            if (j == (int)Math.sqrt(i) + 1) {
                ++ sum;
                System.out.println(i + "是素数" + '\n');

            }

        }
        System.out.println("素数的总数是：" + sum);

    }
}

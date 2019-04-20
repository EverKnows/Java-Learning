/*
    题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？   
    PS: 完全平方数，及其平方根为整数的数
 */
package com.zzxx.exercise;

public class Solution13 {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        for (int i = 1; i <= (int)Math.sqrt(168); ++i) {
            if (168 % i == 0) {
                x = i;
                y = 168 / i;

                if ((Math.pow(x + y, 2) - 268 * 4) == (Math.pow(x - y, 2) - 100 * 4)) {
                    if (0.25 * Math.pow(x + y, 2) - 268 - (int)(0.25 * Math.pow(x + y, 2) - 268) == 0) {
                        System.out.println("x为" + (0.25 * Math.pow(x + y, 2) - 268));
                    }
                }
            }
        }

    }
/*
 设数字为 x
    n^2 = x + 100
    m^2 = x + 268
    相减：
        （m-n）（m+n） = 168
        a = m - n ， b = m + n
        遍历查找组合，要满足x是整数的条件
 */

}

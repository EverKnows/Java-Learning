/*
    题目：输入两个正整数m和n，求其最大公约数和最小公倍数。   
    在循环中，只要除数不等于0，用较大数除以较小的数，将小
    的一个数作为下一轮循环的大数，取得的余数作为下一轮循环
    的较小的数，如此循环直到较小的数的值为0，返回较大的数，
    此数即为最大公约数，最小公倍数为两数之积除以最大公约数。
*/
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int maxCD = maxCommonDivisor(n,m);
        int minCM = (int)(n * m / maxCD);

        System.out.println("最大公约数：" + maxCD);
        System.out.println("最小公倍数" + minCM);
    }
    public static int maxCommonDivisor(int n, int m) {
        int temp;
        int remainder = 0;
        if (n < m) {
            temp = n;
            n = m;
            m = temp;
        }
        if ( n == m) {
            return n;
        }
        while (n % m != 0) {
            remainder = n % m;
            if (remainder > m) {
                temp = remainder;
                remainder = m;
                m = temp;

            }
            n = m;
            m = remainder;

        }
        return m;



    }
}

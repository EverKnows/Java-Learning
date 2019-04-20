/*
    题目：给一个不多于5位的正整数，要求：一、求它是几位数，
    二、逆序打印出各位数字
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution24 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] strArray = str.toCharArray();
        System.out.println("这个数字是" + str.length() + "位数");
        for (int i = str.length() - 1; i >= 0; --i) {
            System.out.print(strArray[i] + " ");

        }
    }
}

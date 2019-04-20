/*
    题目：计算字符串中子串出现的次数  
    例如：字符串abcewegwgegwefwre中we出现了2次；
    字符串aaawersfoitngjaa中aa出现了2次
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution43 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String subStr =scan.nextLine();
        int count = 0;
        int times = 0;

        for (int i = 0; i < str.length(); i++) {
            count = 0;
            for (int j = 0; j < subStr.length(); j++) {
                if (i + count < str.length()) {
                    if (str.charAt(i + count) == subStr.charAt(j)) {
                        ++count;
                        if (count == subStr.length()) {
                            ++times;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(times);
    }
}

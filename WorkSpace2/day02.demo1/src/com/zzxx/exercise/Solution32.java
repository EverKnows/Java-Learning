/*
    题目：取一个整数a从右端开始的4～7位。
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution32 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        String strNum = String.valueOf(num);

        if (strNum.length() >= 4 && strNum.length() <= 7) {
            num = Integer.valueOf(strNum.substring(5, strNum.length() - 1));

        }
        if (strNum.length() <= 4) {
            System.out.println("该整数不足四位");
            num  = -1;

        }
        if (strNum.length() >= 7) {
            num = Integer.valueOf(strNum.substring(5, 8));
        }
        if (num != -1) {
            System.out.println(num);
        }
    }
}

/*
    题目：输入某年某月某日，判断这一天是这一年的第几天？
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution14 {
    public static int[][] monthDays = {{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
            , {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strArray = str.split("\\.");
        int year = Integer.parseInt(strArray[0]);
        int month = Integer.parseInt(strArray[1]);
        int day = Integer.parseInt(strArray[2]);
        int totalDays = 0;

        if (year % 4 == 0 && year % 100 != 0 || year % 400 ==0) {
            totalDays = cacuDays(month, 1, day);

        } else {
            totalDays = cacuDays(month, 0, day);

        }
        System.out.println(totalDays);
    }

    private static int cacuDays(int month, int flag, int days) {
        int totalDays = 0;

        switch(month) {
            case 12:
                totalDays = totalDays + monthDays[flag][11];
            case 11:
                totalDays = totalDays + monthDays[flag][10];
            case 10:
                totalDays = totalDays + monthDays[flag][9];
            case 9:
                totalDays = totalDays + monthDays[flag][8];
            case 8:
                totalDays = totalDays + monthDays[flag][7];
            case 7:
                totalDays = totalDays + monthDays[flag][6];
            case 6:
                totalDays = totalDays + monthDays[flag][5];
            case 5:
                totalDays = totalDays + monthDays[flag][4];
            case 4:
                totalDays = totalDays + monthDays[flag][3];
            case 3:
                totalDays = totalDays + monthDays[flag][2];
            case 2:
                totalDays = totalDays + monthDays[flag][1];
            case 1:
                totalDays = totalDays + monthDays[flag][0];
            default:
                break;
        }
        return totalDays - monthDays[flag][month - 1] + days;
    }

}

/*
    题目：请输入星期几的第一个字母来判断一下是星期几，
    如果第一个字母一样，则继续   判断第二个字母。
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution26 {
    final static String[] record = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public static void main(String[] args) {
        stringMatch();

    }

    private static void stringMatch() {
        Scanner scan = new Scanner(System.in);
        char date = ' ';
        int deep = 0;
        int count = 7;
        boolean flag = true;
        int[] markArr = {0, 0, 0, 0, 0, 0, 0};
        int mark = 0;
        int flag2 = 0;

        while (flag) {
            date = scan.next().charAt(0);
            for (int i = 0; i < 7; ++i) {
                if (markArr[i] != -1) {
                    if (date == record[i].charAt(deep)) {
                        mark = i;
                        flag2 = 1;

                    } else {
                        markArr[i] = -1;
                        --count;

                    }
                    if (deep  == record[i].length() || count == 1) {
                        System.out.println("是" + record[mark]);
                        flag = false;
                        return;
                    }

                }

            }
            if (flag2 == 0) {
                System.out.println("没有对应的匹配项");
                flag = false;

            } else {
                ++deep;
                flag2 = 0;

            }
        }
    }
}

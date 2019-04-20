/*
    题目：一个5位数，判断它是不是回文数。即12321是回文数
    ，个位与万位相同，十位与千位相同。
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution25 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String number = scan.nextLine();
        char[] strArray = number.toCharArray();
        int head = 0;
        int tail = strArray.length - 1;
        boolean flag = true;

        while (tail >= head) {
            if (strArray[head] != strArray[tail]) {
                flag = false;
                break;
            }
            ++head;
            --tail;
        }

        if (flag == true) {
            System.out.println("为回文数");
        } else {
            System.out.println("不是回文数");
        }
    }
}

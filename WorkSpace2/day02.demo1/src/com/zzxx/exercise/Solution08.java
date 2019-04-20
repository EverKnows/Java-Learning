/*
    题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
    例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int srn = scan.nextInt();
        int index = scan.nextInt();
        int sum = 0;
        int num = 0;

        for (int i = index - 1; i >= 0; -- i) {
            for (int j = i; j >= 0; -- j) {
                num = num + (int)Math.pow(10,j);

            }
            System.out.println(num);
            sum = sum + num * srn;
            num = 0;

        }
        System.out.println(sum);
    }
}

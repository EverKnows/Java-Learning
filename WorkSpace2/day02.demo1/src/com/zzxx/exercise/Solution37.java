/*
    题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），
    凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution37 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        boolean flag =true;
        int[] markArr = new int[n];

        while (flag) {

            for (int i = 0; i < n; i++) {
                if (markArr[i] != 1) {
                    ++count;
                    if (count % 3 == 0) {
                        markArr[i] = 1;
                        if (count == 3 * (n - 1)) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (markArr[i] == 0) {
                System.out.println("第" + (i + 1) + "号");

            }
        }
    }
}

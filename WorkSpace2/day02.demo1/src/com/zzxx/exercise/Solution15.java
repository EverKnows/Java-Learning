/*
    题目：输入三个整数x,y,z，请把这三个数由小到大输出。
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();
        int temp;

        if (x > y) {
            temp = x;
            x = y;
            y = temp;

        }
        if (x > z) {
            temp = x;
            x = z;
            z = temp;

        }
        if(y > z) {
            temp = y;
            y = z;
            z = temp;
        }
        System.out.print(x);
        System.out.print("<");
        System.out.print(y);
        System.out.print("<");
        System.out.println(z);

    }
}

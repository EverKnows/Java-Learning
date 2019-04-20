/*
题目：输入3个数a,b,c，按大小顺序输出。
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution34 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[3];
        int temp;

        for (int i = 0; i < 3; i++) {
            arr[i] = scan.nextInt();

        }

        if (arr[0] > arr[2]) {
            temp = arr[0];
            arr[0] = arr[2];
            arr[2] = temp;
        }
        if (arr[1] > arr[2]) {
            temp = arr[1];
            arr[1] = arr[2];
            arr[2] = temp;
        }
        if (arr[0] > arr[1]) {
            temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i]);
        }

    }
}

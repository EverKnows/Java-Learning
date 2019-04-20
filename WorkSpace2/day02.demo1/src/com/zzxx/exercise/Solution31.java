/*
    题目：将一个数组逆序输出。
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution31 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        double[] arr = new double[sum];
        for (int i = 0; i < sum; i++) {
            arr[i] = scan.nextDouble();

        }
        for (int i = arr.length; i > 0; --i) {
            System.out.println(arr[i - 1]);
        }

    }
}

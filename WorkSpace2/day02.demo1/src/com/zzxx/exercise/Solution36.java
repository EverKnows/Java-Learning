/*
题目：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution36 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        double[] arr = new double[n];
        double[] arr2 = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextDouble();

        }

        for (int i = 0; i < n - m; i++) {
            arr2[i + m] = arr[i];

        }
        for (int i = n - m; i < n; i++) {
            arr2[i - n + m] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr2[i]);
        }
    }
}

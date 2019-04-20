/*
题目：求一个3*3矩阵对角线元素之和
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution29 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[][] arr = new double[3][3];
        double sum = 0.0;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                arr[i][j] = scan.nextDouble();

            }

        }
        for (int i = 2; i >= 0; --i) {
            sum = sum + arr[i][i];

        }
        for (int i = 0; i < 3; ++i) {
            sum = sum + arr[i][i];

        }
        System.out.println(sum - arr[1][1]);

    }
}

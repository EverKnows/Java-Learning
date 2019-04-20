/*
    题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution35 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int maxIndex = 0;
        int minIndex = 0;
        double temp;
        double[] arr = new double[num];

        for (int i = 0; i < num; i++) {
            arr[i] = scan.nextDouble();

        }

        for (int i = 0; i < num; i++) {
            if (arr[maxIndex] <= arr[i]) {
                maxIndex = i;

            }
            if (arr[minIndex] <= arr[i]) {
                minIndex = i;
            }
        }
        temp = arr[maxIndex];
        arr[maxIndex] = arr[0];
        arr[0] = temp;
        temp = arr[minIndex];
        arr[minIndex] = arr[num - 1];
        arr[num - 1] = temp;
        for (double i : arr) {
            System.out.println(i);
        }


    }
}

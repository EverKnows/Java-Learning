/*
    题目：对10个数进行排序 
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution28 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] arr = new double[10];
        double temp;
        boolean flag = false;

        for (int i = 0; i < 10; ++i) {
            arr[i] = scan.nextDouble();
        }

        for (int i = 0; i < 10; ++i) {
            flag = false;
            for (int j = 8; j >= 0; --j) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                flag = true;
            }
            if (flag = false) {
                break;
            }
        }
        for (int i = 0; i < 10; ++i) {
            System.out.print(arr[i] + " ");

        }

    }
}

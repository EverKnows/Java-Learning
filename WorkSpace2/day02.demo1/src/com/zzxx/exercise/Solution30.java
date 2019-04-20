/*
    题目：有一个已经排好序的数组。现输入一个数
    ，要求按原来的规律将它插入数组中。 
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution30 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] orderArr = {5, 6, 8, 55, 75, 99, 111};
        double num = scan.nextDouble();
        double[] arr = new double[orderArr.length + 1];
        int mark = 0;
        int flag = 0;

        for (int i = 0; i < orderArr.length - 1; i++) {
            if ((orderArr[i] <= num && orderArr[i + 1] >= num) || (orderArr[i] >= num && orderArr[i + 1] <= num)) {
                mark = i + 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != mark) {
                arr[i] = orderArr[i - flag];
            } else {
                arr[i] = num;
                flag = 1;
            }
        }
        for (double i : arr) {
            System.out.println(i);
        }
    }
}

package com.zzxx.Test;

public class sieveOfEratosthenes {
    public static void main(String[] args) {
        int max = 100;
        int index = 0;
        int[] prime = new int[max + 1];
        int[] flag = new int[max + 1];

        for (int i = 2; i <= max; i++) {
            if (flag[i] == 0) {
                prime[index++] = i;
                for (int j = i; j <= max; j += i) {
                    flag[j] = 1;

                }
            }

        }
        for (int i:prime) {
            System.out.println(i);
        }
    }
}
/*
https://blog.csdn.net/codetypeman/article/details/81459904
时间复杂度：O(nlglgn)
 */
package com.zzxx.Test;


public class LinearSieve {
    public static void main(String[] args) {
        int max = 100;
        int[] flag = new int[max + 1];
        int index = 0;
        int[] prime = new int[max + 1];

        for (int i = 2; i <= max; i++) {
            if (flag[i] == 0) {
                prime[index++] = i;
            }
            for (int j = 0;j < index && prime[j] * i <= max;j++) {
                flag[prime[j] * i] = 1;
                if (i % prime[j] == 0) {
                    break;
                }

            }


        }
        for (int i: prime) {
            System.out.println(i);
        }
    }
}
/*
https://blog.csdn.net/qq958093764/article/details/45334491
时间复杂度：O(n)
 */
/*
    题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。   
    程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：   
    (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。   
    (2)如果n <> k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数你n,重复执行第一步。   
    (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution04 {
    public static void main(String[] args) {
        int inputNum = 0;
        Scanner scan = new Scanner(System.in);

        if (scan.hasNextInt()) {
            inputNum = scan.nextInt();

        }

        if (inputNum != 1) {
            System.out.print(inputNum + "=");
            printPrime(inputNum);
        } else {
            System.out.println("1 = 1。");
        }
    }
    public static void printPrime(int k) {
        for (int i = 2; i <= k; ++i) {
            if (i == k) {
                System.out.print(i + "。");
                break;
            }
            if (k % i == 0) {
                System.out.print(i + "*");
                printPrime((int)(k / i));
                break;
            }
        }
    }
}

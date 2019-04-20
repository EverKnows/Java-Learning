/*
题目：打印出如下图案（菱形）   
     *   
    ***   
   *****   
  *******   
   *****   
    ***   
     *   
 */
package com.zzxx.exercise;

public class Solution19_ {
    public static void main(String[] args) {
        for (int i = 1; i <= (int)(7 / 2) ; ++i) {
            for (int j = 1; j <= (int)(7 / 2) + 1 - i; ++j ){
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1 ; ++k) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= 7 - (int)(7 / 2) ; ++i) {
            for (int j = 1; j <= i - 1 ; ++j) {
                System.out.print(" ");

            }
            for (int k = 1; k <= 7 - 2 * (i - 1) ; ++k) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
}

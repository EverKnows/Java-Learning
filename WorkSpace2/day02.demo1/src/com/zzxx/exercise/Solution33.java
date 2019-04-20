/*
题目：打印出杨辉三角形（要求打印出10行如下图）      
            1   
          1    1   
        1    2    1   
      1    3    3    1   
    1    4    6    4    1   
1    5    10    10    5    1 
 */
package com.zzxx.exercise;

public class Solution33 {
    public static void main(String[] args) {
        int[][] pascalTriangle = new int[10][19];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 19; j++) {
                pascalTriangle[i][j] = 0;
            }
        }


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 19; j++) {
                if (i - 1 < 0 ) {
                    pascalTriangle[i][j] = 0;
                    if (j == 9) {
                        pascalTriangle[0][9] = 1;
                    }
                    continue;
                }
                if (j - 1 < 0 ) {
                    pascalTriangle[i][j] = pascalTriangle[i - 1][j + 1];
                    continue;
                }
                if (j + 1 > 18) {
                    pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1];
                    continue;
                }
                pascalTriangle[i][j] = pascalTriangle[i - 1][j + 1] + pascalTriangle[i - 1][j - 1];

            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 19; j++) {
                if (pascalTriangle[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(pascalTriangle[i][j]);
                }
            }
            System.out.println();
        }
    }
}

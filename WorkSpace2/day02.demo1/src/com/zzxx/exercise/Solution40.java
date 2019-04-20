/*
    题目：字符串排序。(字典顺序)
 */
package com.zzxx.exercise;
import java.util.Arrays;
import java.util.Scanner;

public class Solution40 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //只读取一个整数，读取完以后会把光标停放在同一行，之后的“\n”将无法被读取
        scan.nextLine();        //读取 ’\n‘
        String[] strArr = new String[n];

        for (int i = 0; i < n; i++) {
            strArr[i] = scan.nextLine();

        }

        Arrays.sort(strArr);
        for (String substr : strArr) {
            System.out.println(substr);

        }
    }
}

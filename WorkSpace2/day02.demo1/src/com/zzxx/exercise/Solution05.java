/*
    题目：利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double grade = 0.0;
        if (scan.hasNextDouble()) {
            grade = scan.nextDouble();

        }
        System.out.println(grade >= 60 ? (grade >= 90 ? 'A' : 'B') : 'C');
    }
}

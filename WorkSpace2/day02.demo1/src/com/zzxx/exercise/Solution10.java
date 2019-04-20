/*
    题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；
    再落下，求它在     第10次落地时，共经过多少米？第10次反弹多高？
 */
package com.zzxx.exercise;

public class Solution10 {
    public static void main(String[] args) {
        double height = 100;
        double sum = -100;


        for (int i = 0; i < 10; ++ i) {
            sum = sum + height * 2;
            height = height / 2;
        }
        System.out.println("第10次落地时，一共经过" + sum + "米");
        System.out.println("第10次反弹" + height + "米");
    }
}

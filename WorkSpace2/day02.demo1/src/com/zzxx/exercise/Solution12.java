/*
    题目：企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；利润高于10万元，低于20万元时
    ，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；20万到40万之间时，高于20万元的部分，可提
    成5%；40万到60万之间时高于40万元的部分，可提成3%；60万到100万之间时，高于60万元的部分，可提成1.5%，高
    于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润，求应发放奖金总数？
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入利润：");
        double salary = scan.nextDouble();
        double bonus = 0.0;
        if (salary <=  100000) {
            bonus = 0.1 * salary;

        } else if (salary <= 200000) {
            bonus = 0.1 * 100000 + (salary - 100000) * 0.075;

        } else if (salary <= 400000) {
            bonus = 0.1 * 100000 + 100000 * 0.075 + (salary - 200000) * 0.05;

        } else if (salary <= 600000) {
            bonus = 0.1 * 100000 + 0.075 * 100000 + 0.05 * 200000 + (salary - 400000) * 0.03;

        } else if (salary <= 1000000) {
            bonus = 0.1 * 100000 + 0.075 * 100000 + 0.05 * 200000 +  0.03 * 200000 + (salary - 600000) * 0.015;
        }

        System.out.println("利润是" + bonus);
    }
}

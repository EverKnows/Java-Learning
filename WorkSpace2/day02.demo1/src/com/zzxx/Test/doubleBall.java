package com.zzxx.Test;

import java.util.Arrays;

public class doubleBall {
    public static void main(String[] args) {
        int[] ballArr = new int[36];
        int[] goalArr = new int[7];
        int index = 0;
        int number = 0;
        int temp = 0;
        boolean flag = true;

        for (int i = 0; i < 36; i++) {
            ballArr[i] = 1;
        }
        while (index < 6) {
            number = (int) (Math.random() * 36);
            if (ballArr[number] != 0) {
                goalArr[index++] = number + 1;
                ballArr[number] = 0;

            }

        }
        while (index < 7) {
            number = (int) (Math.random() * 10);
            if (ballArr[number] != 0) {
                goalArr[index++] = number + 1;
                ballArr[number] = 0;

            }
        }
        for (int i = 0; i < 6; ++i) {
            flag = false;
            for (int j = 4; j >= i; --j) {
                if (goalArr[j] > goalArr[j + 1]) {
                    temp = goalArr[j];
                    goalArr[j] = goalArr[j + 1];
                    goalArr[j + 1] = temp;
                }
                flag = true;
            }
            if (flag = false) {
                break;
            }
        }
        System.out.println(Arrays.toString(goalArr));
    }
}

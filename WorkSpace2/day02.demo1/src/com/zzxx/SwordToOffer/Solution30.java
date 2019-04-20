package com.zzxx.SwordToOffer;

public class Solution30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 1)
            return array[0];
        int max = -999;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i])
                max = array[i];
            if (array[i] < 0) {
                continue;
            } else {
                sum = 0;
                for (int j = i; j < array.length; j++) {
                    sum = sum + array[j];
                    if (max < sum)
                        max = sum;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] array = {-2, -8, -5, -1, -9};
        System.out.println(new Solution30().FindGreatestSumOfSubArray(array));
    }
}

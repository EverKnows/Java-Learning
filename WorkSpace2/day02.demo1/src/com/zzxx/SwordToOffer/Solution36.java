package com.zzxx.SwordToOffer;

import java.util.Arrays;

public class Solution36 {
    public int InversePairs(int [] array) {
        if (array.length <= 1)
            return 0;
        int [] copy = new int[array.length];
        int result = mergeSort(array, copy,0, array.length - 1);
        return result % 1000000007;
    }
    public int mergeSort(int [] array, int [] copy, int start, int end) {
        if (start >= end)
            return 0;
        int mid = (start + end) / 2;
        int leftCount = mergeSort(array, copy, start, mid);
        int rightCount = mergeSort(array, copy, mid + 1, end);
        int newCount = merge(array, copy, start, mid, end);
        return leftCount + rightCount + newCount;
    }
    public int merge(int [] array, int [] copy, int start, int mid, int end) {
        int i = mid;
        int j = end;
        int k = end;
        int count = 0;
        //int [] copy = new int[array.length];
        while (i >= start && j >= mid + 1) {
            if (array[i] > array[j]) {
                copy[k--] = array[i--];
                count = count + j - mid;
                if (count >= 1000000007)
                    count %= 1000000007;
            } else {
                copy[k--] = array[j--];
            }
        }
        while (i >= start)
            copy[k--] = array[i--];
        while (j >= mid + 1)
            copy[k--] = array[j--];
        for (int l = start; l < end + 1; l++) {
            array[l] = copy[l];
        }
        return count;
    }

    public static void main(String[] args) {
        int [] array = {1, 2, 3, 4, 5, 6, 8, 0};
        System.out.println(new Solution36().InversePairs(array));
    }
}

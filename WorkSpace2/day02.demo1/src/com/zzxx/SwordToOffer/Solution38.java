package com.zzxx.SwordToOffer;

public class Solution38 {
    public int GetNumberOfK1(int [] array , int k) {
        int leftIndex = binarySearch(array, k - 0.5, 0, array.length - 1);
        int rightIndex = binarySearch(array, k + 0.5, 0, array.length - 1);
        return rightIndex - leftIndex;
    }
    public int binarySearch(int[] array, double k, int low, int high) {
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0)
            return 0;
        int leftIndex = findFirst(array, k, 0, array.length - 1);
        System.out.println("leftIndex : " + leftIndex);
        int rightIndex = findLast(array, k, 0, array.length - 1);
        System.out.println("rightIndex : " + rightIndex);
        if (leftIndex != -1 && rightIndex != -1)
            return rightIndex - leftIndex + 1;
        return 0;

    }
    public int findFirst(int [] array, int k, int low, int high) {
        int mid = 0;
        while (low < high) {
            mid = (high + low) / 2;
            if (array[mid] < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return array[low] == k ? low : -1;
    }
    public int findLast(int [] array, int k, int low, int high) {
        int mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (array[mid] > k) {
                high = mid - 1;
            } else if (array[mid] < k) {
                low = mid + 1;
            } else {
                if (array[mid + 1] != k)
                    return mid;
                if (array[mid + 1] == k)
                    low = mid + 1;
            }
        }
        return array[low] == k ? low : -1;
    }

    public static void main(String[] args) {
        int [] array = {1, 1, 1, 1, 1, 1};
        System.out.println(new Solution38().GetNumberOfK1(array, 2));
    }
}

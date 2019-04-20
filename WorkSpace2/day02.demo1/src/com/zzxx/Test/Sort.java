/*
简单选择排序：O(n^2)
冒泡排序：O(n^2)
插入排序：O(n^2)
快速排序：O(nlogn)
归并排序：O(nlogn)
非递归归并排序：O(nlogn)
 */
package com.zzxx.Test;

public class Sort {
    public Sort() {}

    public static int getPivotKeyIndex(int[] arr, int left, int right) {
        int pivotKey = arr[left];
        while (left < right) {
            while(arr[right] >= pivotKey && left < right)
                --right;
            swap(arr, left, right);
            while(arr[left] <= pivotKey && left < right)
                ++left;
            swap(arr, left, right);
        }
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp;
        temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void quickSort(int[] arr, int left, int right) {
        int pivotKeyIndex;
        if (left < right) {
            pivotKeyIndex = getPivotKeyIndex(arr, left, right);
            quickSort(arr, left, pivotKeyIndex - 1);
            quickSort(arr, pivotKeyIndex + 1, right);
        }
    }
    public static void bubbleSort(int[] arr) {
        boolean flag = true;

        for (int i = 0; i < arr.length - 1; i++) {
            flag = true;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    flag = false;
                }
            }
            if (flag == true)
                break;

        }
    }

    public static void insertSort(int[] arr) {
        int temp;
        int j;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                temp = arr[i];
                //System.out.println(temp);
                // arr[j] >= temp && j >= 0
                // j >= 0 && arr[j] >= temp
                for ( j = i - 1;arr[j] > temp && j >= 0; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
    }

    public static void selectSort(int[] arr) {
        int min;
        int i,j;
        for (i = 0; i < arr.length - 1; i++) {
            min = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min)
                swap(arr, min, i);
        }

    }

    public static void mergeSort(int[] arr) {
        MSort(arr, arr, 0, arr.length - 1);
    }
    public static void MSort(int[] arr,int[] TR1, int s, int t) {
        int mid;
        int[] TR2 = new int[arr.length];
        if (s == t) {
            TR1[s] = arr[s];

        } else {
            mid = (s + t) / 2;
            MSort(arr, TR2, s, mid);
            MSort(arr, TR2, mid + 1, t);
            Merge(TR2, TR1, s, mid, t);
        }

    }
    public static void Merge(int[] TR2, int[] TR1, int s, int m, int n) {
        int i = s;
        int j = m + 1;
        int k = s;

        while(i <= m && j <= n) {
            if (TR2[i] < TR2[j]) {
                TR1[k++] = TR2[i++];
            } else {
                TR1[k++] = TR2[j++];
            }
        }
        while (i <= m)
            TR1[k++] = TR2[i++];
        while(j <= n)
            TR1[k++] = TR2[j++];
    }
    public static void mergeSort_NonRecursive(int[] arr) {
        int[] TR1 = new int[arr.length];
        int k = 1;
        while (k <= arr.length) {
            MergePass(arr, TR1, k, arr.length - 1);
            k *= 2;
            MergePass(TR1, arr, k, arr.length - 1);
            k *= 2;
        }

    }

    public static void MergePass(int[] arr, int[] TR1, int s, int n) {
        int i = 0;
        while (i < n - 2 * s + 1) {
            Merge(arr, TR1, i, i + s -1, i + 2 * s - 1);
            i = i + 2 * s;
        }
        if (i < n - s + 1) {
            Merge(arr, TR1, i, i + s - 1, n);
        } else {
            for (int j = i; j < arr.length; j++) {
                TR1[j] = arr[j];
            }
        }
    }

}

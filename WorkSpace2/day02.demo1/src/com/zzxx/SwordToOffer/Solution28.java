package com.zzxx.SwordToOffer;
import java.util.*;
public class Solution28 {
    /*public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int mid = (array.length / 2) + 1;
        for (int i = 0; i < array.length - mid + 1; i++) {
            if (array[i] == array[i + mid - 1])
                return array[i];
        }
        return 0;
    }*/
    public int MoreThanHalfNum_Solution(int [] array) {
        int mid = (array.length / 2);
        int high = array.length - 1;
        int low = 0;
        int index = Parition(array, low, high);
        while (mid != index) {

            if (mid > index) {
                low = index + 1;
                index = Parition(array, low, high);

            } else {
                high = index - 1;
                index = Parition(array, low, high);
            }

        }
        if (isMoreThanHalf(index, array)) {
            return index;
        } else {
            return 0;
        }
    }
    public boolean isMoreThanHalf(int index,int [] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[index])
                ++count;
        }
        return (count * 2) > array.length;
    }

    public int Parition(int[] array, int low, int high) {
        int pvlot = array[low];
        int i = low;
        int j = high;
        while (j > i) {
            while (j > i && array[j] >= pvlot)
                --j;
            swap(array, i, j);
            while (j > i && array[i] <= pvlot)
                ++i;
            swap(array, i, j);
        }
        return i;
    }
    public void swap(int [] array, int i, int j) {
        int temp = 0;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int []  array = {5, 2, 4, 2, 2, 2, 2, 2, 3, 3};
        System.out.println(array[new Solution28().MoreThanHalfNum_Solution(array)]);
    }
}

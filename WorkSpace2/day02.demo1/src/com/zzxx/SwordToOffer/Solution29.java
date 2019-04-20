package com.zzxx.SwordToOffer;
import java.lang.reflect.Array;
import java.util.*;

public class Solution29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            set.add(input[i]);
        }
        int[] arrayNew = new int[set.size()];
        int index = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            arrayNew[index++] = iterator.next();
        }
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int num = getKnum(i, arrayNew);
            array.add(num);
        }
        return array;


    }
    public int getKnum(int k, int [] array) {
        int low = 0;
        int high = array.length - 1;
        int index = Parition(array, low, high);
        while (k != index) {
            if (k > index) {
                low = index + 1;
                index = Parition(array, low, high);
            } else {
                high = index - 1;
                index = Parition(array, low, high);
            }
        }
        return array[index];
    }
    public void swap(int [] array, int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public int Parition(int [] array, int low, int high) {
        int pvlot = array[low];
        int i = low;
        int j = high;
        while (j > i) {
            while (j > i && array[j] >= pvlot) 
                --j;
            swap(array, i ,j);
            while (j > i && array[i] <= pvlot)
                ++i;
            swap(array, i ,j);
        }
        return i;
    }

    public static void main(String[] args) {
        int [] input = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> array = new Solution29().GetLeastNumbers_Solution(input, 4);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
}

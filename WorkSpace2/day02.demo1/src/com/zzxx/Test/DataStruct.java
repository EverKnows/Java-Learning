package com.zzxx.Test;

import java.util.*;

class Pet {
    int age = 0;
    int sex = 0;
}
public class DataStruct {

    private static String x;

    public static void main(String[] args) {
        List<Pet> myList = new ArrayList<Pet>();
        myList.add(new Pet());
        myList.add(new Pet());
        myList.iterator();
        ListIterator<Pet> myIterator = myList.listIterator();
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next().age);
            myIterator.remove();
        }
        Stack<Pet> myStack = new Stack<Pet>();
        Queue<Pet> myQueue = new LinkedList<>();

        System.out.println();
       // Solution s = new Solution();
       // int[] array = new int[]{2, 4, 6, 1, 3, 5, 7};
        /*for (int i = 0;i < array.length;i++) {
            for (int j = 0;j < array.length - 1 - i;j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
            System.out.println(Arrays.toString(array));
        }
        //System.out.println(Arrays.toString(array));*/


        System.out.println(x);
        System.out.println(x);
        System.out.println(x);
        System.out.println(x);
        System.out.println(x);
    }
}
class Solution {
    public void reOrderArray(int [] array) {
        int[] odd;
        Vector<Integer> vector = new Vector<Integer>();
        vector.add(4);

        odd = Arrays.copyOf(array, array.length);
        int[] even = Arrays.copyOf(array, array.length);
       // Queue<int>
        int countOdd = 0;
        int countEven = 0;
        int i = 0, j = 0;
        int t = 0;
        for (int d : array) {
            if (d % 2 == 0) {
                even[countEven++] = d;
            } else {
                odd[countOdd++] = d;
            }
        }
        while (i < countEven || j < countOdd) {
            while (j < countOdd)
                array[t++] = odd[j++];
            while (i < countEven)
                array[t++] = even[i++];
        }
    }
}

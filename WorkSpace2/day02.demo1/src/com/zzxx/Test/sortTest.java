package com.zzxx.Test;
import com.zzxx.Test.Sort;

import java.util.Arrays;

public class sortTest {
    public static void main(String[] args) {
        int[] arr = {5, 89, 84, 4, 25, 61};
        Sort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

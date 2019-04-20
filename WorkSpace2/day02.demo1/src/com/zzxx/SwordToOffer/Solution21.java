package com.zzxx.SwordToOffer;
import java.util.*;

public class Solution21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Map<Integer, Integer> myMap = new HashMap<>();
        int temp = 0;

        for(int i = 0;i < pushA.length;i++) {
            myMap.put(pushA[i], i);
        }
        for (int i = 0;i < popA.length;i++) {
            if (myMap.get(popA[i]) == null)
                return false;
        }
        for(int i = 0;i < popA.length;i++) {
            temp = myMap.get(popA[i]);
            for (int j = i + 1;j < popA.length;j++) {
                if (myMap.get(popA[j]) < myMap.get(popA[i]) ) {
                    if (temp < myMap.get(popA[j])) {
                        return false;
                    } else {
                        temp = myMap.get(popA[j]);
                    }
                }
            }
        }
        return true;
    }


    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        int pushIndex = 0;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[pushIndex++]);
        do {
            while (pushIndex < pushA.length && stack.peek() != popA[popIndex]) {
                stack.push(pushA[pushIndex++]);
            }
            if (stack.peek() == popA[popIndex]) {
                //stack.pop()
                System.out.println(stack.pop());
                popIndex++;
            } else {
                return false;
            }
        }while(!stack.empty());
        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 3, 5, 1, 2};
        System.out.println(new Solution21().IsPopOrder2(pushA, popA));
    }
}

package com.zzxx.SwordToOffer;
import java.util.*;
public class Solution20 {
    Stack<Integer> stack = new Stack<>();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = stack.peek();
        Iterator<Integer> iterator = stack.iterator();
        while(iterator.hasNext()) {
            int temp = iterator.next();
            if (min > temp)
                min = temp;
        }
        return min;
    }
}

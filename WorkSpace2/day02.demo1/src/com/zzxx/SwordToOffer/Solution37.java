package com.zzxx.SwordToOffer;
import java.util.*;

public class Solution37 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        if (stack1.peek() != stack2.peek())
            return null;
        ListNode preNode = stack1.pop();
        stack2.pop();
        while (!stack1.empty() && !stack2.empty()) {
            if (stack1.peek() != stack2.peek()) {
                return preNode;
            } else {
                preNode = stack1.pop();
                stack2.pop();
            }

        }
        return preNode;

    }
}

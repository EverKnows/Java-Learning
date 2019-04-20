package com.zzxx.SwordToOffer;

import java.util.Stack;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution25 {
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode p = pHead;
        while (p != null) {
            RandomListNode node = new RandomListNode(p.label);
            node.next = p.next;
            p.next = node;
            p = p.next.next;
        }
        p = pHead;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = pHead;
        RandomListNode s = new RandomListNode(0);
        RandomListNode s1 = s;
        while (p != null) {
            RandomListNode node = p.next;
            p.next = node.next;
            node.next = s1.next;
            s1.next = node;
            s1 = s1.next;
            p = p.next;
        }
        return s.next;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.random = head.next.next;
        head.next.next.next = new RandomListNode(4);
        head.next.next.random = head.next;
        RandomListNode node = new Solution25().Clone(head);
        while (node != null) {
            System.out.println("node.label:" + node.label);
            if (node.next != null)
                System.out.println("node.next.label:" + node.next.label);
            if (node.random != null)
                System.out.println("node.random.label:" + node.random.label);
            node = node.next;
        }
    }

}

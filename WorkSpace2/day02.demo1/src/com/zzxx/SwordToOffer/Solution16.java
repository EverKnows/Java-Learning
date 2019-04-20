package com.zzxx.SwordToOffer;

public class Solution16 {
    public ListNode Merge1(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;

        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
                node = node.next;
            } else {
                node.next = list2;
                list2 = list2.next;
                node = node.next;
            }
        }
        while (list1 != null) {
            node.next = list1;
            node = node.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            node.next = list2;
            node = node.next;
            list2 = list2.next;
        }
        return head.next;

    }
    public ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;
        ListNode tempNode = null;
        if(list1.val < list2.val) {
            tempNode = list1;
            tempNode.next = Merge2(list1.next, list2);
        } else {
            tempNode = list2;
            tempNode.next = Merge2(list1, list2.next);
        }
        return tempNode;
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        ListNode newList = new Solution16().Merge2(list1, list2);
        while (newList != null) {
            System.out.print(newList.val);
            newList = newList.next;
        }
    }
}

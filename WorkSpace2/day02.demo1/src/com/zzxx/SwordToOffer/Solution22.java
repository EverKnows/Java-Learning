package com.zzxx.SwordToOffer;

import java.util.*;

public class Solution22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> array = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            array.add(node.val);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        return array;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(1);
        ArrayList<Integer> array = new Solution22().PrintFromTopToBottom(root);
        Iterator<Integer> iterator = array.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(' ');
        }
    }
}

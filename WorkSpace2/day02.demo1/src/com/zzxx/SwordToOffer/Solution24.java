package com.zzxx.SwordToOffer;

import java.util.*;

public class Solution24 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrayPath = new ArrayList<>();
        if (root == null)
            return arrayPath;
        Stack<Integer> stack = new Stack<>();
        //  arrayPath.add(new ArrayList<Integer>());
        caulPath(root, target, arrayPath, stack);
        return arrayPath;
    }
    public void caulPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> array, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        stack.push(root.val);
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                array.add(new ArrayList<Integer>(stack));
                //stack.pop();
            }
            stack.pop();
            return;
        }
        caulPath(root.left, target - root.val, array, stack);
        caulPath(root.right, target - root.val, array, stack);
        stack.pop();

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);

        ArrayList<Integer> arrays = new Solution24().FindPath(root, 11).get(1);
        int i = 0;
        while(i < arrays.size()) {
            System.out.println(arrays.get(i));
            i++;
        }
    }
}

package com.zzxx.SwordToOffer;

import java.util.Stack;

public class Solution26 {
    public static TreeNode pre = null;
    /*public TreeNode Convert(TreeNode pRootOfTree) {
        Stack<TreeNode> stack = new Stack<>();
        addToStack(stack, pRootOfTree);
        System.out.println(stack.size());
        TreeNode head = stack.pop();
        TreeNode p = head;
        p.right = null;
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            p.left = node;
            node.right = p;
            p = p.left;
        }
        p.left = null;
        return p;
    }
    public void addToStack(Stack<TreeNode> stack, TreeNode node) {
        if (node != null) {
            addToStack(stack, node.left);
            stack.push(node);
            addToStack(stack , node.right);
        }
    }*/
    public TreeNode Convert(TreeNode pRootOfTree) {
        //Stack<TreeNode> stack = new Stack<>();
        if (pRootOfTree == null)
            return null;
        TreeNode node = pRootOfTree;
        TreeNode pre = new TreeNode(0);
        addToStack(node);
        System.out.println(pre.val);
        while (pRootOfTree.left != null) {
            System.out.println(pRootOfTree.val);
            pRootOfTree = pRootOfTree.left;
        }

        return pRootOfTree;
    }
    public void addToStack(TreeNode node) {
        if (node != null) {
            addToStack(node.left);
            node.left = pre;
            if (pre != null)
                pre.right = node;
            pre = node;
            addToStack(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(7);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        TreeNode node = new Solution26().Convert(root);
        while (node != null) {
            System.out.println("node.val = " + node.val);
            node = node.right;
        }
    }
}

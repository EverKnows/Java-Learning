package com.zzxx.SwordToOffer;


public class Solution18 {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode node = null;
        node = root.left;
        root.left = root.right;
        root.right = node;
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        new Solution18().Mirror(root);
        MidOrder.midOrder(root);
    }
}

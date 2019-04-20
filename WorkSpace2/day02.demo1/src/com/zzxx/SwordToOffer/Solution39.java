package com.zzxx.SwordToOffer;

import javax.swing.tree.TreePath;

public class Solution39 {
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println("Depth : " + new Solution39().TreeDepth(root));
    }
}

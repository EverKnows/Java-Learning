package com.zzxx.SwordToOffer;


public class Solution17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return firstOrder(root1, root2);

    }
    public boolean firstOrder(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null && root2 != null)
            return false;
        if (root1 != null && root2 == null)
            return true;
        if(isSubtree(root1, root2)) {
            return true;
        } else {
            return firstOrder(root1.left , root2) || firstOrder(root1.right, root2);
        }
    }
    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null && root2 != null)
            return false;
        if (root1 != null && root2 == null)
            return true;
        if (root1.val == root2.val) {
            return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
        } else {
            return false;
        }
        //return false;

    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.left.left = new TreeNode(9);
        root1.left.left.left = new TreeNode(2);
        root1.left.left.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.left.left = new TreeNode(3);
        System.out.println(new Solution17().HasSubtree(root1, root2));
    }
}

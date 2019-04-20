package com.zzxx.SwordToOffer;

public class Solution40 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return false;
        Boolean flag = true;
        int depth = getDepth(root, flag);
        System.out.println(depth);
        return flag;
    }
    public int getDepth(TreeNode root, Boolean flag) {
        if (flag == false)
            return -1;
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int leftDepth = getDepth(root.left, flag);
        int rightDepth = getDepth(root.right, flag);
        if (Math.sqrt(leftDepth - rightDepth) > 1)
            flag = false;
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(2);
        //root.right.right = new TreeNode(3);
        System.out.println("Depth : " + new Solution40().IsBalanced_Solution(root));
    }
}

package com.zzxx.SwordToOffer;

public class MidOrder {
    public static void midOrder(TreeNode root) {
        if (root != null) {
            midOrder(root.left);
            System.out.print(root.val);
            midOrder(root.right);
        } else {
            System.out.print('#');
        }
    }

}

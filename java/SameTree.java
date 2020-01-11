package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2020-01-11
 */
public class SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        }
        return  (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public void demo() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(isSameTree(root1, root2));
    }

    public static void main(String[] args) {
        new SameTree().demo();
    }
}

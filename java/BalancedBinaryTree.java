package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2020-01-25
 */
public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public void demo() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        boolean balanced = isBalanced(root);
        System.out.println(balanced);
    }

    public static void main(String[] args) {
        new BalancedBinaryTree().demo();
    }
}

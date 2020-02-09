package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2020-02-09
 */
public class BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxPathSum(TreeNode root) {
        int[] result = {Integer.MIN_VALUE};
        helper(root, result);
        return result[0];
    }

    private int helper(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(helper(root.left, result), 0);
        int right = Math.max(helper(root.right, result), 0);
        result[0] = Math.max(result[0], left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public void demo() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxPathSum(root));
    }

    public static void main(String[] args) {
        new BinaryTreeMaximumPathSum().demo();
    }
}

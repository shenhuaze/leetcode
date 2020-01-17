package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2020-01-17
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // inorder: 左根右
        // postorder: 左右根
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        return helper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int postStart, int postEnd,
                            int[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int i = inStart;
        while (i <= inEnd) {
            if (inorder[i] == postorder[postEnd]) {
                break;
            }
            i += 1;
        }
        root.left = helper(postorder, postStart, postStart + i - inStart - 1, inorder, inStart, i - 1);
        root.right = helper(postorder, postStart + i - inStart, postEnd - 1, inorder, i + 1, inEnd);
        return root;
    }

    public void demo() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println();
    }

    public static void main(String[] args) {
        new ConstructBinaryTreeFromInorderAndPostorderTraversal().demo();
    }
}

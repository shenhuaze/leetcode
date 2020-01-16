package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2020-01-16
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder: 根左右
        // inorder: 左根右
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd,
                            int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = inStart;
        while (i <= inEnd) {
            if (inorder[i] == preorder[preStart]) {
                break;
            }
            i += 1;
        }
        root.left = helper(preorder, preStart + 1, preStart + i - inStart, inorder, inStart, i - 1);
        root.right = helper(preorder, preStart + i - inStart + 1, preEnd, inorder, i + 1, inEnd);
        return root;
    }

    public void demo() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println();
    }

    public static void main(String[] args) {
        new ConstructBinaryTreeFromPreorderAndInorderTraversal().demo();
    }
}

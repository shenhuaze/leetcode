package com.huaze.shen;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Huaze Shen
 * @date 2019-10-27
 */
public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Solution 1
     * Recursion, Traversal
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        inorder(results, root);
        return results;
    }

    private void inorder(List<Integer> results, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(results, root.left);
        results.add(root.val);
        inorder(results, root.right);
    }

    /**
     * Solution 2
     * Recursion, Divide & Conquer
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        results.addAll(inorderTraversal2(root.left));
        results.add(root.val);
        results.addAll(inorderTraversal2(root.right));
        return results;
    }

    /**
     * Solution 3
     * Non-recursion
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        while (currNode != null || !stack.empty()) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            results.add(currNode.val);
            currNode = currNode.right;
        }
        return results;
    }

    /**
     * Solution 4
     * Non-recursion
     */
    public List<Integer> inorderTraversal4(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        while (currNode != null || !stack.empty()) {
            if (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                currNode = stack.pop();
                results.add(currNode.val);
                currNode = currNode.right;
            }
        }
        return results;
    }

    private void demo() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        //List<Integer> results = inorderTraversal(root);
        //List<Integer> results = inorderTraversal2(root);
        //List<Integer> results = inorderTraversal3(root);
        List<Integer> results = inorderTraversal4(root);
        System.out.println(results);
    }

    public static void main(String[] args) {
        new BinaryTreeInorderTraversal().demo();
    }
}

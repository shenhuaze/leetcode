package com.huaze.shen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-10-29
 */
public class UniqueBinarySearchTreesII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> results = new ArrayList<>();
        if (start > end) {
            results.add(null);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = helper(start, i - 1);
            List<TreeNode> rightNodes = helper(i + 1, end);
            for (TreeNode leftNode: leftNodes) {
                for (TreeNode rightNode: rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    results.add(root);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<TreeNode> results = new UniqueBinarySearchTreesII().generateTrees(3);
        //List<TreeNode> results = new UniqueBinarySearchTreesII().helper(2, 2);
        System.out.println(results);
    }
}

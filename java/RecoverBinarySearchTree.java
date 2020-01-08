package com.huaze.shen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-11-11
 */
public class RecoverBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();
        inorder(root, nodeList, valueList);
        Collections.sort(valueList);
        for (int i = 0; i < valueList.size(); i++) {
            nodeList.get(i).val = valueList.get(i);
        }
    }

    private void inorder(TreeNode root, List<TreeNode> nodeList, List<Integer> valueList) {
        if (root == null) {
            return;
        }
        inorder(root.left, nodeList, valueList);
        nodeList.add(root);
        valueList.add(root.val);
        inorder(root.right, nodeList, valueList);
    }

    public void demo() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        recoverTree(root);
        System.out.println();
    }

    public static void main(String[] args) {
        new RecoverBinarySearchTree().demo();
    }
}

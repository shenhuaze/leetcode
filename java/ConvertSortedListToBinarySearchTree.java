package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2020-01-24
 */
public class ConvertSortedListToBinarySearchTree {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode leftLast = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            leftLast = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        TreeNode root = new TreeNode(slow.val);
        leftLast.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightHead);
        return root;
    }

    public void demo() {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        TreeNode root = sortedListToBST(head);
        System.out.println();
    }

    public static void main(String[] args) {
        new ConvertSortedListToBinarySearchTree().demo();
    }
}

package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-10-05
 */
public class RemoveDuplicatesFromSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        while (pre != null) {
            ListNode cur = pre;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            pre.next = cur.next;
            pre = pre.next;
        }
        return head;
    }

    private void demo() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode result = new RemoveDuplicatesFromSortedList().deleteDuplicates(head);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    public static void main(String[] ars) {
        new RemoveDuplicatesFromSortedList().demo();
    }
}

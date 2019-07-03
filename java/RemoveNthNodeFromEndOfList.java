package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-03
 */
public class RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        if (cur == null) {
            return head.next;
        }
        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    private void demo() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        ListNode result = removeNthFromEnd(head, n);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static void main(String[] args) {
        new RemoveNthNodeFromEndOfList().demo();
    }
}

package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-08-15
 */
public class RotateList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n += 1;
        }
        tail.next = head;
        int cutPosition = n - k % n - 1;
        ListNode newTail = head;
        for (int i = 0; i < cutPosition; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    private void demo() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        ListNode newHead = rotateRight(head, 2);
        while (newHead != null) {
            System.out.print(newHead.val + " -> ");
            newHead = newHead.next;
        }
    }

    public static void main(String[] args) {
        new RotateList().demo();
    }
}

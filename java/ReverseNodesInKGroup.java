package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-08
 */
public class ReverseNodesInKGroup {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        pre.next = head;
        int i = 1;
        while (cur != null) {
            if (i % k == 0) {
                pre = reverseEachGroup(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
            i += 1;
        }
        return dummy.next;
    }

    private ListNode reverseEachGroup(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

    private void demo() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 3;
        ListNode result = reverseKGroup(head, k);
        while (result != null) {
            System.out.print(String.valueOf(result.val) + " -> ");
            result = result.next;
        }
    }

    public static void main(String[] args) {
        new ReverseNodesInKGroup().demo();
    }
}

package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-10-05
 */
public class RemoveDuplicatesFromSortedListII {
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
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        while (pre.next != null) {
            ListNode cur = pre.next;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (cur == pre.next) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
        }
        return dummy.next;
    }

    private void demo() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode result = new RemoveDuplicatesFromSortedListII().deleteDuplicates(head);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    public static void main(String[] args) {
        new RemoveDuplicatesFromSortedListII().demo();
    }
}

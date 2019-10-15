package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-10-06
 */
public class PartitionList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Solution 1
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.val < x) {
            pre = pre.next;
        }
        ListNode cur = pre;
        while (cur.next != null) {
            if (cur.next.val < x) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
                pre = pre.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * Solution 2
     */
    public ListNode partition2(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode newDummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode newCur = newDummy;
        while (cur.next != null) {
            if (cur.next.val < x) {
                newCur.next = cur.next;
                newCur = newCur.next;
                cur.next = cur.next.next;
                newCur.next = null;
            } else {
                cur = cur.next;
            }
        }
        newCur.next = dummy.next;
        return newDummy.next;
    }

    private void demo() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        int x = 3;
        //ListNode result = new PartitionList().partition(head, x);
        ListNode result = new PartitionList().partition2(head, x);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    public static void main(String[] args) {
        new PartitionList().demo();
    }
}

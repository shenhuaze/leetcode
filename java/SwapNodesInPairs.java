package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-06
 *
 * 交换顺序的流程如下：("="指的是赋值，"->"指的是next指向)
 *   temp = pre.next.next
 *   pre.next -> temp.next
 *   temp -> pre.next
 *   pre -> temp
 *   pre = temp.next
 */
public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Solution 1
     *
     * 交换顺序的流程如下：("="指的是赋值，"->"指的是next指向)
     *   temp = pre.next.next
     *   pre.next -> temp.next
     *   temp -> pre.next
     *   pre -> temp
     *   pre = temp.next
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode temp = pre.next.next;
            pre.next.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            pre = temp.next;
        }
        return dummy.next;
    }

    /**
     * Solution 2
     */
    public ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsRecursion(newHead.next);
        newHead.next = head;
        return newHead;
    }

    private void demo() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //ListNode result = swapPairs(head);
        ListNode result = swapPairsRecursion(head);
        while (result != null) {
            System.out.print(String.valueOf(result.val) + " -> ");
            result = result.next;
        }
    }

    public static void main(String[] args) {
        new SwapNodesInPairs().demo();
    }
}

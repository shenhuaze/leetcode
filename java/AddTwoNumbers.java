package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-06-13
 */
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        int d1;
        int d2;
        int sum;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                d1 = l1.val;
            } else {
                d1 = 0;
            }
            if (l2 != null) {
                d2 = l2.val;
            } else {
                d2 = 0;
            }
            sum = d1 + d2 + carry;
            if (sum < 10) {
                carry = 0;
            } else {
                carry = 1;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    public void demo() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        new AddTwoNumbers().demo();
    }
}

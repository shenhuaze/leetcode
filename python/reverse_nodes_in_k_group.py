"""
Author: Huaze Shen
Date: 2019-07-08
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def reverse_k_group(head, k):
    if head is None or k == 1:
        return head
    dummy = ListNode(0)
    pre = dummy
    cur = head
    pre.next = cur
    i = 1
    while cur:
        if i % k == 0:
            pre = reverse_each_group(pre, cur.next)
            cur = pre.next
        else:
            cur = cur.next
        i += 1
    return dummy.next


def reverse_each_group(pre, next_):
    last = pre.next
    cur = last.next
    while cur != next_:
        last.next = cur.next
        cur.next = pre.next
        pre.next = cur
        cur = last.next
    return last


if __name__ == "__main__":
    head_ = ListNode(1)
    head_.next = ListNode(2)
    head_.next.next = ListNode(3)
    head_.next.next.next = ListNode(4)
    head_.next.next.next.next = ListNode(5)
    k_ = 3
    result = reverse_k_group(head_, k_)
    while result:
        print(result.val)
        result = result.next

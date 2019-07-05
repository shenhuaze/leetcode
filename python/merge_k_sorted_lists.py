"""
Author: Huaze Shen
Date: 2019-07-05
"""

import heapq


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def merge_k_lists(lists):
    """
    Solution 1
    """
    if lists is None or len(lists) == 0:
        return None
    n = len(lists)
    while n > 1:
        k = (n + 1) // 2
        for i in range(n // 2):
            lists[i] = merge_two_lists(lists[i], lists[i + k])
        n = k
    return lists[0]


def merge_two_lists(l1, l2):
    dummy = ListNode(0)
    cur = dummy
    while l1 and l2:
        if l1.val < l2.val:
            cur.next = l1
            l1 = l1.next
        else:
            cur.next = l2
            l2 = l2.next
        cur = cur.next
    if l1:
        cur.next = l1
    else:
        cur.next = l2
    return dummy.next


def merge_k_lists2(lists):
    """
    Solution 2
    """
    if lists is None or len(lists) == 0:
        return None
    heap = []
    for node in lists:
        while node:
            heapq.heappush(heap, node.val)
            node = node.next
    dummy = ListNode(0)
    cur = dummy
    while heap:
        node_val = heapq.heappop(heap)
        cur.next = ListNode(node_val)
        cur = cur.next
    return dummy.next


if __name__ == "__main__":
    l1_ = ListNode(1)
    l1_.next = ListNode(4)
    l1_.next.next = ListNode(5)
    l2_ = ListNode(1)
    l2_.next = ListNode(3)
    l2_.next.next = ListNode(4)
    l3_ = ListNode(2)
    l3_.next = ListNode(6)
    lists_ = [l1_, l2_, l3_]
    # result = merge_k_lists(lists_)
    result = merge_k_lists2(lists_)
    while result:
        print(result.val)
        result = result.next

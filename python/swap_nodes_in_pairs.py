"""
Author: Huaze Shen
Date: 2019-07-06
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def swap_pairs(head):
    """
    Solution 1
    """
    dummy = ListNode(0)
    pre = dummy
    pre.next = head
    while pre.next and pre.next.next:
        temp = pre.next.next
        pre.next.next = temp.next
        temp.next = pre.next
        pre.next = temp
        pre = temp.next
    return dummy.next


def swap_pairs_recursion(head):
    """
    Solution 2
    """
    if not head or not head.next:
        return head
    new_head = head.next
    # 下面两行的顺序不能换
    head.next = swap_pairs_recursion(new_head.next)
    new_head.next = head
    return new_head


if __name__ == '__main__':
    head_ = ListNode(1)
    head_.next = ListNode(2)
    head_.next.next = ListNode(3)
    head_.next.next.next = ListNode(4)
    # result = swap_pairs(head_)
    result = swap_pairs_recursion(head_)
    while result:
        print(result.val)
        result = result.next

"""
@author Huaze Shen
@date 2019-10-27
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def reverse_between(head, m, n):
    dummy = ListNode(-1)
    dummy.next = head
    pre = dummy
    cur = head
    for i in range(m - 1):
        pre = pre.next
        cur = cur.next
    for i in range(m, n):
        temp = cur.next
        cur.next = temp.next
        temp.next = pre.next
        pre.next = temp
    return dummy.next


if __name__ == '__main__':
    head_ = ListNode(1)
    head_.next = ListNode(2)
    head_.next.next = ListNode(3)
    head_.next.next.next = ListNode(4)
    head_.next.next.next.next = ListNode(5)
    m_ = 2
    n_ = 4
    result = reverse_between(head_, m_, n_)
    while result:
        print(result.val)
        result = result.next

"""
@author Huaze Shen
@date 2019-10-06
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def partition(head, x):
    dummy = ListNode(0)
    dummy.next = head
    pre = dummy
    while pre.next and pre.next.val < x:
        pre = pre.next
    cur = pre
    while cur.next:
        if cur.next.val < x:
            temp = cur.next
            cur.next = temp.next
            temp.next = pre.next
            pre.next = temp
            pre = pre.next
        else:
            cur = cur.next
    return dummy.next


if __name__ == '__main__':
    head_ = ListNode(1)
    head_.next = ListNode(4)
    head_.next.next = ListNode(3)
    head_.next.next.next = ListNode(2)
    head_.next.next.next.next = ListNode(5)
    head_.next.next.next.next.next = ListNode(2)
    x_ = 3
    result_ = partition(head_, x_)
    while result_:
        print(result_.val)
        result_ = result_.next

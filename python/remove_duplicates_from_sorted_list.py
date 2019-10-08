"""
@author Huaze Shen
@date 2019-10-05
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def delete_duplicates(head):
    if head is None or head.next is None:
        return head
    pre = head
    while pre:
        cur = pre
        while cur.next and cur.val == cur.next.val:
            cur = cur.next
        pre.next = cur.next
        pre = pre.next
    return head


if __name__ == '__main__':
    head_ = ListNode(1)
    head_.next = ListNode(2)
    head_.next.next = ListNode(3)
    head_.next.next.next = ListNode(3)
    head_.next.next.next.next = ListNode(4)
    head_.next.next.next.next.next = ListNode(4)
    head_.next.next.next.next.next.next = ListNode(5)
    result = delete_duplicates(head_)
    while result:
        print(result.val)
        result = result.next

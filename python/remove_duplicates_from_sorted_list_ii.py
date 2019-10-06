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
    dummy = ListNode(0)
    pre = dummy
    dummy.next = head
    while pre.next:
        cur = pre.next
        while cur.next and cur.val == cur.next.val:
            cur = cur.next
        if cur == pre.next:
            pre = pre.next
        else:
            pre.next = cur.next
    return dummy.next


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

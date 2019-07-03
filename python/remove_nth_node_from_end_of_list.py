
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def remove_nth_from_end(head, n):
    if not head:
        return None
    pre = head
    cur = head
    for i in range(n):
        cur = cur.next
    if not cur:
        return head.next
    while cur.next:
        pre = pre.next
        cur = cur.next
    pre.next = pre.next.next
    return head


if __name__ == "__main__":
    head_ = ListNode(1)
    head_.next = ListNode(2)
    head_.next.next = ListNode(3)
    head_.next.next.next = ListNode(4)
    head_.next.next.next.next = ListNode(5)
    n_ = 2
    result = remove_nth_from_end(head_, n_)
    while result:
        print(result.val)
        result = result.next

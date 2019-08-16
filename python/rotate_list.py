
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def rotate_right(head, k):
    if head is None:
        return None
    n = 1
    tail = head
    while tail.next is not None:
        n += 1
        tail = tail.next
    tail.next = head
    new_tail = head
    for i in range(n - k % n - 1):
        new_tail = new_tail.next
    new_head = new_tail.next
    new_tail.next = None
    return new_head


if __name__ == '__main__':
    head_ = ListNode(0)
    head_.next = ListNode(1)
    head_.next.next = ListNode(2)
    head_.next.next.next = ListNode(3)
    head_.next.next.next.next = ListNode(4)
    new_head_ = rotate_right(head_, 2)
    while new_head_ is not None:
        print(new_head_.val)
        new_head_ = new_head_.next

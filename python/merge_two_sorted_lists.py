
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def merge_two_lists(l1, l2):
    dummy = ListNode(0)
    cur = dummy
    while l1 is not None and l2 is not None:
        if l1.val < l2.val:
            cur.next = l1
            l1 = l1.next
        else:
            cur.next = l2
            l2 = l2.next
        cur = cur.next
    if l1 is not None:
        cur.next = l1
    else:
        cur.next = l2
    return dummy.next


if __name__ == "__main__":
    l1_ = ListNode(1)
    l1_.next = ListNode(2)
    l1_.next.next = ListNode(4)
    l2_ = ListNode(1)
    l2_.next = ListNode(3)
    l2_.next.next = ListNode(4)
    result = merge_two_lists(l1_, l2_)
    while result is not None:
        print(result.val)
        result = result.next

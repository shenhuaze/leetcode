
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def add_two_numbers(l1, l2):
    dummy = ListNode(-1)
    cur = dummy
    carry = 0
    while l1 is not None or l2 is not None:
        if l1 is not None:
            d1 = l1.val
        else:
            d1 = 0
        if l2 is not None:
            d2 = l2.val
        else:
            d2 = 0
        sum = d1 + d2 + carry
        if sum < 10:
            carry = 0
        else:
            carry = 1
        cur.next = ListNode(sum % 10)
        cur = cur.next
        if l1 is not None:
            l1 = l1.next
        if l2 is not None:
            l2 = l2.next
    if carry == 1:
        cur.next = ListNode(1)
    return dummy.next


if __name__ == "__main__":
    l1_ = ListNode(2)
    l1_.next = ListNode(4)
    l1_.next.next = ListNode(3)
    l2_ = ListNode(5)
    l2_.next = ListNode(6)
    l2_.next.next = ListNode(4)
    result = add_two_numbers(l1_, l2_)
    result_list = []
    while result is not None:
        result_list.append(str(result.val))
        result = result.next
    print(" -> ".join(result_list))

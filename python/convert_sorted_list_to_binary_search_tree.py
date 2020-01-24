# @author Huaze Shen
# @date 2020-01-24


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def sorted_list_to_bst(head):
    if head is None:
        return None
    if head.next is None:
        return TreeNode(head.val)
    last = head
    slow = head
    fast = head
    while fast is not None and fast.next is not None:
        last = slow
        slow = slow.next
        fast = fast.next.next
    root = TreeNode(slow.val)
    right_head = slow.next
    last.next = None
    root.left = sorted_list_to_bst(head)
    root.right = sorted_list_to_bst(right_head)
    return root


if __name__ == '__main__':
    head_ = ListNode(-10)
    head_.next = ListNode(-3)
    head_.next.next = ListNode(0)
    head_.next.next.next = ListNode(5)
    head_.next.next.next.next = ListNode(9)
    root_ = sorted_list_to_bst(head_)
    print()

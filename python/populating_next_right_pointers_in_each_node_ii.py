# @author Huaze Shen
# @date 2020-02-01


class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


def connect(root):
    if root is None:
        return root
    p = root.next
    while p is not None:
        if p.left is not None:
            p = p.left
            break
        if p.right is not None:
            p = p.right
            break
        p = p.next
    if root.right is not None:
        root.right.next = p
    if root.left is not None:
        if root.right is not None:
            root.left.next = root.right
        else:
            root.left.next = p
    connect(root.right)
    connect(root.left)
    return root


if __name__ == '__main__':
    root_ = Node(1)
    root_.left = Node(2)
    root_.right = Node(3)
    root_.left.left = Node(4)
    root_.left.right = Node(5)
    root_.right.right = Node(7)
    root__ = connect(root_)
    print()
# @author Huaze Shen
# @date 2020-01-31


class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


def connect(root):
    if root is None:
        return root
    if root.left is not None:
        root.left.next = root.right
    if root.right is not None:
        if root.next is not None:
            root.right.next = root.next.left
        else:
            root.right.next = None
    connect(root.left)
    connect(root.right)
    return root


if __name__ == '__main__':
    root_ = Node(1)
    root_.left = Node(2)
    root_.right = Node(3)
    root_.left.left = Node(4)
    root_.left.right = Node(5)
    root_.right.left = Node(6)
    root_.right.right = Node(7)
    root__ = connect(root_)
    print()

# @author Huaze Shen
# @date 2020-01-12


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def is_symmetric(root):
    if root is None:
        return True
    return is_equal(root.left, root.right)


def is_equal(left, right):
    if left is None and right is None:
        return True
    elif left is None:
        return False
    elif right is None:
        return False
    elif left.val != right.val:
        return False
    return is_equal(left.right, right.left) and is_equal(left.left, right.right)


if __name__ == '__main__':
    root_ = TreeNode(1)
    root_.left = TreeNode(2)
    root_.right = TreeNode(2)
    root_.left.left = TreeNode(3)
    root_.right.right = TreeNode(3)
    root_.left.right = TreeNode(4)
    root_.right.left = TreeNode(4)
    print(is_symmetric(root_))

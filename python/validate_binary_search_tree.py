# @author Huaze Shen
# @date 2019-11-16

import sys


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def is_valid_bst(root):
    return helper(root, -sys.maxsize + 1, sys.maxsize)


def helper(root, low, high):
    if root is None:
        return True
    if root.val <= low or root.val >= high:
        return False
    return helper(root.left, low, root.val) and helper(root.right, root.val, high)


if __name__ == '__main__':
    root_ = TreeNode(2)
    root_.left = TreeNode(1)
    root_.right = TreeNode(3)
    print(is_valid_bst(root_))

# @author Huaze Shen
# @date 2020-02-09

import sys


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def max_path_sum(root):
    result = [-2**32]
    helper(root, result)
    return result[0]


def helper(root, result):
    if root is None:
        return 0
    left = max(helper(root.left, result), 0)
    right = max(helper(root.right, result), 0)
    result[0] = max(result[0], left + right + root.val)
    return max(left, right) + root.val


if __name__ == '__main__':
    root_ = TreeNode(1)
    root_.left = TreeNode(2)
    root_.right = TreeNode(3)
    print(max_path_sum(root_))

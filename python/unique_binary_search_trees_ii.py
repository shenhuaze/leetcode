"""
@author Huaze Shen
@date 2019-11-05
"""


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def generate_trees(n):
    if n == 0:
        return []
    return helper(1, n)


def helper(start, end):
    results = []
    if start > end:
        results.append(None)
    for i in range(start, end + 1):
        left_nodes = helper(start, i - 1)
        right_nodes = helper(i + 1, end)
        for left_node in left_nodes:
            for right_node in right_nodes:
                root = TreeNode(i)
                root.left = left_node
                root.right = right_node
                results.append(root)
    return results


if __name__ == '__main__':
    results_ = generate_trees(2)

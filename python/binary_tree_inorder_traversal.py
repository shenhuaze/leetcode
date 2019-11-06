"""
@author Huaze Shen
@date 2019-10-27
"""


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def inorder_traversal(root):
    results = []
    stack = []
    curr_node = root
    while curr_node is not None or len(stack) > 0:
        if curr_node is not None:
            stack.append(curr_node)
            curr_node = curr_node.left
        else:
            curr_node = stack.pop()
            results.append(curr_node.val)
            curr_node = curr_node.right
    return results


if __name__ == '__main__':
    root_ = TreeNode(1)
    root_.right = TreeNode(2)
    root_.right.left = TreeNode(3)
    print(inorder_traversal(root_))

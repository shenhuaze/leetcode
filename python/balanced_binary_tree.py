# @author Huaze Shen
# @date 2020-01-25


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def is_balanced(root):
    if root is None:
        return True
    return is_balanced(root.left) and is_balanced(root.right) and abs(depth(root.left) - depth(root.right)) <= 1


def depth(root):
    if root is None:
        return 0
    return max(depth(root.left), depth(root.right)) + 1


if __name__ == '__main__':
    root_ = TreeNode(3)
    root_.left = TreeNode(9)
    root_.right = TreeNode(20)
    root_.right.left = TreeNode(15)
    root_.right.right = TreeNode(7)
    print(is_balanced(root_))

# @author Huaze Shen
# @date 2020-01-15


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def max_depth(root):
    if root is None:
        return 0
    return max(max_depth(root.left), max_depth(root.right)) + 1


if __name__ == '__main__':
    root_ = TreeNode(3)
    root_.left = TreeNode(9)
    root_.right = TreeNode(20)
    root_.right.left = TreeNode(15)
    root_.right.right = TreeNode(7)
    print(max_depth(root_))

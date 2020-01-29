# @author Huaze Shen
# @date 2020-01-29


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def flatten(root):
    if root is None:
        return
    flatten(root.left)
    flatten(root.right)
    temp = root.right
    root.right = root.left
    root.left = None
    while root.right is not None:
        root = root.right
    root.right = temp


if __name__ == '__main__':
    root_ = TreeNode(1)
    root_.left = TreeNode(2)
    root_.left.left = TreeNode(3)
    root_.left.right = TreeNode(4)
    root_.right = TreeNode(5)
    root_.right.right = TreeNode(6)
    flatten(root_)
    while root_ is not None:
        print(root_.val)
        root_ = root_.right

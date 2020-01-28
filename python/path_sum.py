# @author Huaze Shen
# @date 2020-01-27


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def has_path_sum(root, sum):
    if root is None:
        return False
    if root.left is None and root.right is None and root.val == sum:
        return True
    return has_path_sum(root.left, sum - root.val) or has_path_sum(root.right, sum - root.val)


if __name__ == '__main__':
    root_ = TreeNode(5)
    root_.left = TreeNode(4)
    root_.left.left = TreeNode(11)
    root_.left.left.left = TreeNode(7)
    root_.left.left.right = TreeNode(2)
    root_.right = TreeNode(8)
    root_.right.left = TreeNode(13)
    root_.right.right = TreeNode(4)
    root_.right.right.right = TreeNode(1)
    print(has_path_sum(root_, 22))

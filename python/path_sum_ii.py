# @author Huaze Shen
# @date 2020-01-28


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def path_sum(root, sum):
    results = []
    path = []
    helper(results, path, root, sum)
    return results


def helper(results, path, root, sum):
    if root is None:
        return
    path.append(root.val)
    if root.val == sum and root.left is None and root.right is None:
        results.append(path[:])
    helper(results, path, root.left, sum - root.val)
    helper(results, path, root.right, sum - root.val)
    path.pop(len(path) - 1)


if __name__ == '__main__':
    root_ = TreeNode(5)
    root_.left = TreeNode(4)
    root_.left.left = TreeNode(11)
    root_.left.left.left = TreeNode(7)
    root_.left.left.right = TreeNode(2)
    root_.right = TreeNode(8)
    root_.right.left = TreeNode(13)
    root_.right.right = TreeNode(4)
    root_.right.right.left = TreeNode(5)
    root_.right.right.right = TreeNode(1)
    print(path_sum(root_, 22))

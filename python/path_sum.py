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
    # TreeNode root = new TreeNode(5);
    #         root.left = new TreeNode(4);
    #         root.left.left = new TreeNode(11);
    #         root.left.left.left = new TreeNode(7);
    #         root.left.left.right = new TreeNode(2);
    #         root.right = new TreeNode(8);
    #         root.right.left = new TreeNode(13);
    #         root.right.right = new TreeNode(4);
    #         root.right.right.right = new TreeNode(1);
    #         System.out.println(hasPathSum(root, 22));
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

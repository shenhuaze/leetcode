# @author Huaze Shen
# @date 2020-01-16


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def build_tree(preorder, inorder):
    if preorder is None or len(preorder) == 0:
        return None
    return helper(preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1)


def helper(preorder, pre_start, pre_end, inorder, in_start, in_end):
    if pre_start > pre_end or in_start > in_end:
        return None
    # 这里注意一定不要把pre_start写成0了
    root = TreeNode(preorder[pre_start])
    i = in_start
    while i <= in_end:
        # 这里注意一定不要把pre_start写成0了
        if preorder[pre_start] == inorder[i]:
            break
        i += 1
    root.left = helper(preorder, pre_start + 1, pre_start + i - in_start, inorder, in_start, i - 1)
    root.right = helper(preorder, pre_start + i - in_start + 1, pre_end, inorder, i + 1, in_end)
    return root


if __name__ == '__main__':
    preorder_ = [3, 9, 20, 15, 7]
    inorder_ = [9, 3, 15, 20, 7]
    root_ = build_tree(preorder_, inorder_)
    print()

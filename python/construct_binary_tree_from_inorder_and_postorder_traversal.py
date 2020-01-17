# @author Huaze Shen
# @date 2020-01-17


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def build_tree(inorder, postorder):
    if inorder is None or len(inorder) == 0:
        return None
    return helper(postorder, 0, len(postorder) - 1, inorder, 0, len(inorder) - 1)


def helper(postorder, post_start, post_end, inorder, in_start, in_end):
    if post_start > post_end or in_start > in_end:
        return None
    root = TreeNode(postorder[post_end])
    i = in_start
    while i <= in_end:
        if inorder[i] == postorder[post_end]:
            break
        i += 1
    root.left = helper(postorder, post_start, post_start + i - in_start - 1, inorder, in_start, i - 1)
    root.right = helper(postorder, post_start + i - in_start, post_end - 1, inorder, i + 1, in_end)
    return root


if __name__ == '__main__':
    inorder_ = [9, 3, 15, 20, 7]
    postorder_ = [9, 15, 7, 20, 3]
    root_ = build_tree(inorder_, postorder_)
    print()

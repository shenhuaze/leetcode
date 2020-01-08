# @author Huaze Shen
# @date 2020-01-08


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def recover_tree(root):
    node_list = []
    value_list = []
    inorder(root, node_list, value_list)
    value_list = sorted(value_list)
    for i in range(len(value_list)):
        node_list[i].val = value_list[i]


def inorder(root, node_list, value_list):
    """
    中序遍历
    """
    if not root:
        return
    inorder(root.left, node_list, value_list)
    node_list.append(root)
    value_list.append(root.val)
    inorder(root.right, node_list, value_list)


if __name__ == '__main__':
    root_ = TreeNode(1)
    root_.left = TreeNode(3)
    root_.left.right = TreeNode(2)
    recover_tree(root_)
    print()

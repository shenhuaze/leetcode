# @author Huaze Shen
# @date 2020-01-13


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def level_order(root):
    results = []
    if root is None:
        return results
    queue = [root]
    while len(queue) > 0:
        size = len(queue)
        level_list = []
        for i in range(size):
            node = queue.pop(0)
            if node is None:
                continue
            level_list.append(node.val)
            if node.left is not None:
                queue.append(node.left)
            if node.right is not None:
                queue.append(node.right)
        results.append(level_list)
    return results


if __name__ == '__main__':
    root_ = TreeNode(3)
    root_.left = TreeNode(9)
    root_.right = TreeNode(20)
    root_.right.left = TreeNode(15)
    root_.right.right = TreeNode(7)
    print(level_order(root_))

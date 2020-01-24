# @author Huaze Shen
# @date 2020-01-23


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def sorted_array_to_bst(nums):
    return helper(nums, 0, len(nums) - 1)


def helper(nums, left, right):
    if left > right:
        return None
    mid = left + (right - left) // 2
    root = TreeNode(nums[mid])
    root.left = helper(nums, left, mid - 1)
    root.right = helper(nums, mid + 1, right)
    return root


if __name__ == '__main__':
    nums_ = [-10, -3, 0, 5, 9]
    root_ = sorted_array_to_bst(nums_)
    print()

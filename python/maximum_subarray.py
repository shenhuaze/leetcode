"""
@author Huaze Shen
@date 2019-08-01
"""


def max_sub_array(nums):
    return helper(nums, 0, len(nums) - 1)


def helper(nums, left, right):
    if left == right:
        return nums[left]
    p = (left + right) // 2
    left_sum = helper(nums, left, p)
    right_sum = helper(nums, p + 1, right)
    cross_sum = cross(nums, left, right, p)
    return max(left_sum, right_sum, cross_sum)


def cross(nums, left, right, p):
    if left == right:
        return nums[left]
    left_max_sum = -2**31
    curr_sum = 0
    i = p
    while i >= left:
        curr_sum += nums[i]
        left_max_sum = max(left_max_sum, curr_sum)
        i -= 1
    i = p + 1
    right_max_sum = -2**31
    curr_sum = 0
    while i <= right:
        curr_sum += nums[i]
        right_max_sum = max(right_max_sum, curr_sum)
        i += 1
    return left_max_sum + right_max_sum


if __name__ == '__main__':
    nums_ = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    print(max_sub_array(nums_))

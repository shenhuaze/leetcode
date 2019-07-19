"""
@author Huaze Shen
@date 2019-07-19
"""


def first_missing_positive(nums):
    if nums is None or len(nums) == 0:
        return 1
    size = len(nums)
    for i in range(size):
        while 0 < nums[i] <= size and nums[nums[i] - 1] != nums[i]:
            swap(nums, nums[i] - 1, i)
    for i in range(size):
        if nums[i] != i + 1:
            return i + 1
    return size + 1


def swap(nums, i, j):
    temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp


if __name__ == '__main__':
    nums_ = [-1, 4, 2, 1, 9, 10]
    print(first_missing_positive(nums_))

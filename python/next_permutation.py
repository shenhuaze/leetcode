"""
Author: Huaze Shen
Date: 2019-07-11
"""


def next_permutation(nums):
    length = len(nums)
    i = length - 2
    while i >= 0:
        if nums[i] < nums[i + 1]:
            j = length - 1
            while j > i:
                if nums[j] > nums[i]:
                    break
                j -= 1
            swap(nums, i, j)
            reverse(nums, i + 1)
            return
        i -= 1
    reverse(nums, 0)


def swap(nums, i, j):
    temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp


def reverse(nums, i):
    left = i
    right = len(nums) - 1
    while left < right:
        swap(nums, left, right)
        left += 1
        right -= 1


if __name__ == '__main__':
    nums_ = [3, 2, 1]
    next_permutation(nums_)
    print(nums_)

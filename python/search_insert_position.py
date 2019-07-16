"""
Author: Huaze Shen
Date: 2019-07-16
"""


def search_insert(nums, target):
    if nums is None or len(nums) == 0:
        return 0
    start = 0
    end = len(nums) - 1
    while start + 1 < end:
        mid = (start + end) // 2
        if target > nums[mid]:
            start = mid
        elif target < nums[mid]:
            end = mid
        else:
            return mid
    if target <= nums[start]:
        return start
    elif target <= nums[end]:
        return end
    else:
        return end + 1


if __name__ == '__main__':
    nums_ = [1, 3, 5, 6]
    target_ = 5
    print(search_insert(nums_, target_))

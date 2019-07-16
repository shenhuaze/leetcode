"""
Author: Huaze Shen
Date: 2019-07-15
"""


def search(nums, target):
    if nums is None or len(nums) == 0:
        return -1
    start = 0
    end = len(nums) - 1
    while start + 1 < end:
        mid = (start + end) // 2
        start_value = nums[start]
        if nums[mid] >= start_value:
            if target >= nums[mid]:
                start = mid
            elif target >= start_value:
                end = mid
            else:
                start = mid
        else:
            if target <= nums[mid]:
                end = mid
            elif target < start_value:
                start = mid
            else:
                end = mid
    if nums[start] == target:
        return start
    if nums[end] == target:
        return end
    return -1


if __name__ == '__main__':
    nums_ = [4, 5, 6, 7, 0, 1, 2]
    target_ = 0
    print(search(nums_, target_))

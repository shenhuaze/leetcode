"""
Author: Huaze Shen
Date: 2019-07-16
"""


def search_range(nums, target):
    result = [-1, -1]
    if nums is None or len(nums) == 0:
        return result
    first_position = find_first_position(nums, target)
    last_position = find_last_position(nums, target)
    result[0] = first_position
    result[1] = last_position
    return result


def find_first_position(nums, target):
    start = 0
    end = len(nums) - 1
    while start + 1 < end:
        mid = (start + end) // 2
        if target > nums[mid]:
            start = mid
        else:
            end = mid
    if target == nums[start]:
        return start
    if target == nums[end]:
        return end
    return -1


def find_last_position(nums, target):
    start = 0
    end = len(nums) - 1
    while start + 1 < end:
        mid = (start + end) // 2
        if target >= nums[mid]:
            start = mid
        else:
            end = mid
    if target == nums[end]:
        return end
    if target == nums[start]:
        return start
    return -1


if __name__ == '__main__':
    nums_ = [5, 7, 7, 8, 8, 10]
    target_ = 8
    print(search_range(nums_, target_))

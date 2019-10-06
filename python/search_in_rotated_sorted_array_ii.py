"""
@author Huaze Shen
@date 2019-10-05
"""


def search(nums, target):
    if nums is None or len(nums) == 0:
        return False
    start = 0
    end = len(nums) - 1
    while start + 1 < end:
        mid = (start + end) // 2
        start_value = nums[start]
        if nums[mid] > start_value:
            if target >= nums[mid]:
                start = mid
            elif target >= start_value:
                end = mid
            else:
                start = mid
        elif nums[mid] < start_value:
            if target <= nums[mid]:
                end = mid
            elif target < start_value:
                start = mid
            else:
                end = mid
        else:
            start += 1
    return nums[start] == target or nums[end] == target


if __name__ == '__main__':
    nums_ = [2, 5, 6, 0, 0, 1, 2]
    target_ = 0
    print(search(nums_, target_))

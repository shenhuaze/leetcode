"""
Author: Huaze Shen
Date: 2019-07-09
"""


def remove_duplicates(nums):
    if nums is None or len(nums) == 0:
        return 0
    length = 1
    for i in range(1, len(nums)):
        if nums[i] == nums[i - 1]:
            continue
        length += 1
        nums[length - 1] = nums[i]
    return length


if __name__ == '__main__':
    nums_ = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
    length_ = remove_duplicates(nums_)
    print(nums_[:length_])

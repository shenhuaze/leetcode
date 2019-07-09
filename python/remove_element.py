"""
Author: Huaze Shen
Date: 2019-07-09
"""


def remove_element(nums, val):
    if nums is None or len(nums) == 0:
        return 0
    length = 0
    for i in range(len(nums)):
        if nums[i] == val:
            continue
        nums[length] = nums[i]
        length += 1
    return length


if __name__ == '__main__':
    nums_ = [0, 1, 2, 2, 3, 0, 4, 2]
    val_ = 2
    length_ = remove_element(nums_, val_)
    print(nums_[:length_])

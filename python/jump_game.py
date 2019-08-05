"""
@author Huaze Shen
@date 2019-08-03
"""


def can_jump(nums):
    if nums is None or len(nums) == 0:
        return False
    left_most_good_index = len(nums) - 1
    for i in reversed(range(len(nums) - 1)):
        if i + nums[i] >= left_most_good_index:
            left_most_good_index = i
    return left_most_good_index == 0


if __name__ == '__main__':
    nums_ = [3, 2, 1, 0, 4]
    print(can_jump(nums_))

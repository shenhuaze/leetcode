"""
@author Huaze Shen
@date 2019-07-24
"""


def jump(nums):
    if nums is None or len(nums) < 2:
        return 0
    level = 0
    i = 0
    current_max = 0
    while i <= current_max:
        furthest = current_max
        for j in range(i, current_max + 1):
            furthest = max(furthest, j + nums[j])
            if furthest >= len(nums) - 1:
                return level + 1
        i = current_max + 1
        current_max = furthest
        level += 1
    return -1


if __name__ == '__main__':
    nums_ = [2, 3, 1, 1, 4]
    print(jump(nums_))

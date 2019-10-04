"""
@author Huaze Shen
@date 2019-10-03
"""


def remove_duplicates(nums):
    index = 0
    for num in nums:
        if index < 2 or num > nums[index - 2]:
            nums[index] = num
            index += 1
    return index


if __name__ == '__main__':
    nums_ = [1, 1, 1, 2, 2, 3]
    print(remove_duplicates(nums_))

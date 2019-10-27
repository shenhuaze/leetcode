"""
@author Huaze Shen
@date 2019-10-26
"""


def subsets_with_dup(nums):
    results = []
    result = []
    nums = sorted(nums)
    helper(results, result, nums, 0)
    return results


def helper(results, result, nums, start_index):
    results.append(result[:])
    if start_index >= len(nums):
        return
    for i in range(start_index, len(nums)):
        if i > start_index and nums[i] == nums[i - 1]:
            continue
        result.append(nums[i])
        helper(results, result, nums, i + 1)
        result.pop()


if __name__ == '__main__':
    nums_ = [1, 2, 2]
    results_ = subsets_with_dup(nums_)
    for result_ in results_:
        print(result_)

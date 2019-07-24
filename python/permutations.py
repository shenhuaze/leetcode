"""
@author Huaze Shen
@date 2019-07-24
"""


def permute(nums):
    results = []
    if nums is None or len(nums) == 0:
        return results
    permutation = []
    used_index_set = set()
    helper(results, permutation, nums, used_index_set)
    return results


def helper(results, permutation, nums, used_index_set):
    if len(permutation) == len(nums):
        results.append(permutation[:])
        return
    for i in range(len(nums)):
        if i in used_index_set:
            continue
        permutation.append(nums[i])
        used_index_set.add(i)
        helper(results, permutation, nums, used_index_set)
        permutation.pop()
        used_index_set.remove(i)


if __name__ == '__main__':
    nums_ = [1, 2, 3]
    print(permute(nums_))

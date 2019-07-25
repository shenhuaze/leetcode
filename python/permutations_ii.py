"""
@author Huaze Shen
@date 2019-07-25
"""


def permute_unique(nums):
    results = []
    if nums is None or len(nums) == 0:
        return results
    permutation = []
    nums = sorted(nums)
    visited = [0 for i in range(len(nums))]
    helper(results, permutation, nums, visited)
    return results


def helper(results, permutation, nums, visited):
    if len(permutation) == len(nums):
        results.append(permutation[:])
        return
    for i in range(len(nums)):
        if visited[i] == 1:
            continue
        if i > 0 and visited[i - 1] == 0 and nums[i] == nums[i - 1]:
            continue
        visited[i] = 1
        permutation.append(nums[i])
        helper(results, permutation, nums, visited)
        visited[i] = 0
        permutation.pop()


if __name__ == '__main__':
    nums_ = [1, 1, 2]
    print(permute_unique(nums_))

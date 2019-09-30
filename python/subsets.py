"""
@author Huaze Shen
@date 2019-09-28
"""


def subsets(nums):
    results = [[]]
    for i in range(len(nums)):
        size = len(results)
        for j in range(size):
            results.append(results[j][:])
            results[j].append(nums[i])
    return results


if __name__ == '__main__':
    nums_ = [1, 2, 3]
    results_ = subsets(nums_)
    for result in results_:
        print(result)

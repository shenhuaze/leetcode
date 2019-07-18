"""
@author Huaze Shen
@date 2019-07-18
"""


def combination_sum(candidates, target):
    results = []
    if candidates is None or len(candidates) == 0:
        return results
    candidates = sorted(candidates)
    combination = []
    helper(results, combination, candidates, 0, target)
    return results


def helper(results, combination, candidates, start_index, remain_target):
    if remain_target == 0:
        results.append(combination[:])
        return
    for i in range(start_index, len(candidates)):
        if candidates[i] > remain_target:
            return
        combination.append(candidates[i])
        helper(results, combination, candidates, i, remain_target - candidates[i])
        combination.pop()


if __name__ == '__main__':
    candidates_ = [3, 2, 6, 7]
    target_ = 7
    print(combination_sum(candidates_, target_))

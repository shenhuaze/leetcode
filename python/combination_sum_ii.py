"""
@author Huaze Shen
@date 2019-07-19
"""


def combination_sum_2(candidates, target):
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
        if i > start_index and candidates[i] == candidates[i - 1]:
            continue
        combination.append(candidates[i])
        helper(results, combination, candidates, i + 1, remain_target - candidates[i])
        combination.pop()


if __name__ == '__main__':
    candidates_ = [10, 1, 2, 7, 6, 1, 5]
    target_ = 8
    print(combination_sum_2(candidates_, target_))

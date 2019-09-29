"""
@author Huaze Shen
@date 2019-09-28
"""


def combine(n, k):
    results = []
    result = []
    helper(results, result, 1, n, k)
    return results


def helper(results, result, level, n, k):
    if len(result) == k:
        results.append(result[:])
        return
    for i in range(level, n + 1):
        result.append(i)
        helper(results, result, i + 1, n, k)
        result.pop()


if __name__ == '__main__':
    results_ = combine(5, 3)
    for result_ in results_:
        print(result_)

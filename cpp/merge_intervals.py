"""
@author Huaze Shen
@date 2019-08-07
"""


def merge(intervals):
    if intervals is None or len(intervals) == 0 or intervals[0] is None or len(intervals[0]) == 0:
        return []
    intervals = sorted(intervals, key=lambda d: d[0])
    results = [intervals[0]]
    for i in range(1, len(intervals)):
        if intervals[i][0] > results[len(results) - 1][1]:
            results.append(intervals[i])
        else:
            results[len(results) - 1][1] = max(results[len(results) - 1][1], intervals[i][1])
    return results


if __name__ == '__main__':
    intervals_ = [[1, 3], [2, 6], [8, 10], [15, 18]]
    print(merge(intervals_))

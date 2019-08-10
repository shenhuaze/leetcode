"""
@author Huaze Shen
@date 2019-08-07
"""


def insert(intervals, new_interval):
    if intervals is None or len(intervals) == 0 or intervals[0] is None or len(intervals[0]) == 0:
        return [new_interval]
    if new_interval is None or len(new_interval) == 0:
        return intervals
    results = []
    new_start = new_interval[0]
    new_end = new_interval[1]
    index = 0
    size = len(intervals)
    while index < size and intervals[index][0] < new_start:
        results.append(intervals[index])
        index += 1
    if len(results) == 0 or results[len(results) - 1][1] < new_start:
        results.append(new_interval)
    else:
        last_index = len(results) - 1
        last_end = results[last_index][1]
        results[last_index][1] = max(last_end, new_end)
    while index < size:
        interval = intervals[index]
        last_index = len(results) - 1
        last_end = results[last_index][1]
        if last_end < interval[0]:
            results.append(interval)
        else:
            results[last_index][1] = max(last_end, interval[1])
        index += 1
    return results


if __name__ == '__main__':
    intervals_ = [[1, 5]]
    new_interval_ = [0, 3]
    print(insert(intervals_, new_interval_))

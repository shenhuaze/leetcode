"""
@author Huaze Shen
@date 2019-10-06
"""


def maximal_rectangle(matrix):
    if matrix is None or len(matrix) == 0 or matrix[0] is None or len(matrix[0]) == 0:
        return 0
    m = len(matrix)
    n = len(matrix[0])
    heights = [0 for i in range(n)]
    result = 0
    for i in range(m):
        for j in range(n):
            if matrix[i][j] == '0':
                heights[j] = 0
            else:
                heights[j] += 1
        result = max(result, largest_rectangle_area(heights))
    return result


def largest_rectangle_area(heights):
    result = 0
    for i in range(len(heights)):
        if i < len(heights) - 1 and heights[i] <= heights[i + 1]:
            continue
        min_h = heights[i]
        for j in reversed(range(i + 1)):
            min_h = min(min_h, heights[j])
            area = min_h * (i - j + 1)
            result = max(area, result)
    return result


if __name__ == '__main__':
    matrix_ = [
        ['1', '0', '1', '0', '0'],
        ['1', '0', '1', '1', '1'],
        ['1', '1', '1', '1', '1'],
        ['1', '0', '0', '1', '0']
    ]
    print(maximal_rectangle(matrix_))

"""
@author Huaze Shen
@date 2019-08-01
"""


def spiral_order(matrix):
    result = []
    if matrix is None or len(matrix) == 0 or len(matrix[0]) == 0:
        return result
    m = len(matrix)
    n = len(matrix[0])
    up = 0
    down = m - 1
    left = 0
    right = n - 1
    while up < down and left < right:
        for i in range(left, right + 1):
            result.append(matrix[up][i])
        for i in range(up + 1, down + 1):
            result.append(matrix[i][right])
        for i in reversed(range(left, right)):
            result.append(matrix[down][i])
        for i in reversed(range(up + 1, down)):
            result.append(matrix[i][left])
        up += 1
        down -= 1
        left += 1
        right -= 1
    if up == down:
        for i in range(left, right + 1):
            result.append(matrix[up][i])
    elif left == right:
        for i in range(up, down + 1):
            result.append(matrix[i][left])
    return result


if __name__ == '__main__':
    matrix_ = [
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9, 10, 11, 12]
    ]
    print(spiral_order(matrix_))

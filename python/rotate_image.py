"""
@author Huaze Shen
@date 2019-07-25
"""


def rotate(matrix):
    if matrix is None:
        return
    start = 0
    end = len(matrix) - 1
    while start < end:
        for i in range(end - start):
            temp = matrix[start][start + i]
            matrix[start][start + i] = matrix[end - i][start]
            matrix[end - i][start] = matrix[end][end - i]
            matrix[end][end - i] = matrix[start + i][end]
            matrix[start + i][end] = temp
        start += 1
        end -= 1


if __name__ == '__main__':
    matrix_ = [
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9, 10, 11, 12],
        [13, 14, 15, 16]
    ]
    rotate(matrix_)
    for row in matrix_:
        print(row)

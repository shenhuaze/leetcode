

def search_matrix(matrix, target):
    if matrix is None or len(matrix) == 0 or matrix[0] is None or len(matrix[0]) == 0:
        return False
    m = len(matrix)
    n = len(matrix[0])
    start = 0
    end = m * n - 1
    while start + 1 < end:
        mid = (start + end) // 2
        if matrix[mid // n][mid % n] < target:
            start = mid
        elif matrix[mid // n][mid % n] > target:
            end = mid
        else:
            return True
    return matrix[start // n][start % n] == target or matrix[end // n][end % n] == target


if __name__ == '__main__':
    matrix_ = [
        [1, 3, 5, 7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
    ]
    target_ = 3
    print(search_matrix(matrix_, target_))

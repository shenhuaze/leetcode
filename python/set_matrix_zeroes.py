

def set_zeroes(matrix):
    m = len(matrix)
    n = len(matrix[0])
    first_row_is_zero = False
    first_col_is_zero = False
    for i in range(n):
        if matrix[0][i] == 0:
            first_row_is_zero = True
            break
    for i in range(m):
        if matrix[i][0] == 0:
            first_col_is_zero = True
            break
    for i in range(1, m):
        for j in range(1, n):
            if matrix[i][j] == 0:
                matrix[i][0] = 0
                matrix[0][j] = 0
    for i in range(1, m):
        for j in range(1, n):
            if matrix[i][0] == 0 or matrix[0][j] == 0:
                matrix[i][j] = 0
    if first_row_is_zero:
        for i in range(n):
            matrix[0][i] = 0
    if first_col_is_zero:
        for i in range(m):
            matrix[i][0] = 0


if __name__ == '__main__':
    # matrix_ = [
    #     [1, 1, 1],
    #     [1, 0, 1],
    #     [1, 1, 1]
    # ]
    matrix_ = [
        [1, 0, 3]
    ]
    set_zeroes(matrix_)
    for row in matrix_:
        print(row)

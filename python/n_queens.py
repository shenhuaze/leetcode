"""
@author Huaze Shen
@date 2019-07-26
"""


def solve_nqueens(n):
    results = []
    if n <= 0:
        return results
    cols = []
    search(results, cols, n)
    return results


def search(results, cols, n):
    if len(cols) == n:
        results.append(draw_chessboard(cols))
        return
    for i in range(n):
        if not is_valid(cols, i):
            continue
        cols.append(i)
        search(results, cols, n)
        cols.pop()


def draw_chessboard(cols):
    chessboard = []
    for i in range(len(cols)):
        row = ""
        for j in range(len(cols)):
            if j == cols[i]:
                row += "Q"
            else:
                row += "."
        chessboard.append(row)
    return chessboard


def is_valid(cols, column):
    current_size = len(cols)
    for i in range(current_size):
        if cols[i] == column:
            return False
        if i + cols[i] == current_size + column:
            return False
        if i - cols[i] == current_size - column:
            return False
    return True


if __name__ == '__main__':
    results_ = solve_nqueens(4)
    for result in results_:
        for each in result:
            print(each)
        print()

"""
@author Huaze Shen
@date 2019-07-17
"""


def solve_sudoku(board):
    if board is None or len(board) != 9 or len(board[0]) != 9:
        return
    solve_sudoku_dfs(board, 0, 0)


def solve_sudoku_dfs(board, i, j):
    if i == 9:
        return True
    if j >= 9:
        return solve_sudoku_dfs(board, i + 1, 0)
    if board[i][j] == '.':
        for k in range(9):
            board[i][j] = chr(ord('0') + k + 1)
            if is_valid(board, i, j):
                if solve_sudoku_dfs(board, i, j + 1):
                    return True
            board[i][j] = '.'
    else:
        return solve_sudoku_dfs(board, i, j + 1)


def is_valid(board, i, j):
    for col in range(9):
        if col != j and board[i][col] == board[i][j]:
            return False
    for row in range(9):
        if row != i and board[row][j] == board[i][j]:
            return False
    for row in range(i // 3 * 3, i // 3 * 3 + 3):
        for col in range(j // 3 * 3, j // 3 * 3 + 3):
            if row != i and col != j and board[row][col] == board[i][j]:
                return False
    return True


if __name__ == '__main__':
    board_ = [
        ['5', '3', '.', '.', '7', '.', '.', '.', '.'],
        ['6', '.', '.', '1', '9', '5', '.', '.', '.'],
        ['.', '9', '8', '.', '.', '.', '.', '6', '.'],
        ['8', '.', '.', '.', '6', '.', '.', '.', '3'],
        ['4', '.', '.', '8', '.', '3', '.', '.', '1'],
        ['7', '.', '.', '.', '2', '.', '.', '.', '6'],
        ['.', '6', '.', '.', '.', '.', '2', '8', '.'],
        ['.', '.', '.', '4', '1', '9', '.', '.', '5'],
        ['.', '.', '.', '.', '8', '.', '.', '7', '9']
    ]
    solve_sudoku(board_)
    for row_ in board_:
        print(" ".join(row_))

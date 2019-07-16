"""
@author Huaze Shen
@date 2019-07-16
"""


def is_valid_sudoku(board):
    return is_valid_row(board) and is_valid_column(board) and is_valid_sub_box(board)


def is_valid_row(board):
    size = len(board)
    for i in range(size):
        s = set()
        for j in range(size):
            ch = board[i][j]
            if ch == '.':
                continue
            if ch in s:
                return False
            s.add(ch)
    return True


def is_valid_column(board):
    size = len(board)
    for i in range(size):
        s = set()
        for j in range(size):
            ch = board[j][i]
            if ch == '.':
                continue
            if ch in s:
                return False
            s.add(ch)
    return True


def is_valid_sub_box(board):
    size = len(board)
    num_sub_box = 3
    sub_size = size // num_sub_box
    for i in range(num_sub_box):
        for j in range(num_sub_box):
            s = set()
            row_start = i * sub_size
            col_start = j * sub_size
            for k in range(sub_size):
                for l in range(sub_size):
                    ch = board[row_start + k][col_start + l]
                    if ch == '.':
                        continue
                    if ch in s:
                        return False
                    s.add(ch)
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
    print(is_valid_sudoku(board_))

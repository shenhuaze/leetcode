"""
@author Huaze Shen
@date 2019-09-30
"""


def exist(board, word):
    if board is None or len(board) == 0 or board[0] is None or len(board[0]) == 0:
        return False
    m = len(board)
    n = len(board[0])
    for i in range(m):
        for j in range(n):
            if search(board, i, j, m, n, word, 0):
                return True
    return False


def search(board, i, j, m, n, word, index):
    if index == len(word):
        return True
    if i < 0 or j < 0 or i >= m or j >=n or board[i][j] == "#" or board[i][j] != word[index]:
        return False
    ch = board[i][j]
    board[i][j] = "#"
    result = (search(board, i - 1, j, m, n, word, index + 1) or
              search(board, i + 1, j, m, n, word, index + 1) or
              search(board, i, j - 1, m, n, word, index + 1) or
              search(board, i, j + 1, m, n, word, index + 1))
    board[i][j] = ch
    return result


if __name__ == '__main__':
    board_ = [
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ]
    word_ = "ABCCED"
    print(exist(board_, word_))


"""
@author Huaze Shen
@date 2019-07-27
"""


def total_n_queens(n):
    if n <= 0:
        return 0
    count_list = []
    cols = []
    search(cols, count_list, n)
    return len(count_list)


def search(cols, count_list, n):
    if len(cols) == n:
        count_list.append(1)
        return
    for i in range(n):
        if not is_valid(cols, i):
            continue
        cols.append(i)
        search(cols, count_list, n)
        cols.pop()


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
    print(total_n_queens(4))

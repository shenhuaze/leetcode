# @author Huaze Shen
# @date 2020-02-03


def get_row(row_index):
    result = [0 for i in range(row_index + 1)]
    result[0] = 1
    for i in range(1, row_index + 1):
        for j in reversed(range(1, i + 1)):
            result[j] += result[j - 1]
    return result


if __name__ == '__main__':
    print(get_row(3))

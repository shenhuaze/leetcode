# @author Huaze Shen
# @date 2020-02-04


def minimum_total(triangle):
    m = len(triangle)
    row = [0 for i in range(m)]
    row[0] = triangle[0][0]
    for i in range(1, m):
        for j in reversed(range(0, i + 1)):
            if j == 0:
                min_value = row[j]
            elif j == i:
                min_value = row[j - 1]
            else:
                min_value = min(row[j - 1], row[j])
            row[j] = min_value + triangle[i][j]
    total_min = row[0]
    for i in range(1, m):
        if row[i] < total_min:
            total_min = row[i]
    return total_min


if __name__ == '__main__':
    triangle_ = [
        [2],
        [3, 4],
        [6, 5, 7],
        [4, 1, 8, 3]
    ]
    print(minimum_total(triangle_))

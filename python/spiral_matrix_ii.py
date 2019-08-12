

def generate_matrix(n):
    results = [[0 for i in range(n)] for i in range(n)]
    left = 0
    right = n - 1
    up = 0
    down = n - 1
    current_num = 1
    while left < right and up < down:
        for i in range(left, right + 1):
            results[up][i] = current_num
            current_num += 1
        for i in range(up + 1, down + 1):
            results[i][right] = current_num
            current_num += 1
        for i in reversed(range(left, right)):
            results[down][i] = current_num
            current_num += 1
        for i in reversed(range(up + 1, down)):
            results[i][left] = current_num
            current_num += 1
        left += 1
        right -= 1
        up += 1
        down -= 1
    if up == down:
        for i in range(left, right + 1):
            results[up][i] = current_num
            current_num += 1
    elif left == right:
        for i in range(up, down + 1):
            results[i][left] = current_num
            current_num += 1
    return results


if __name__ == '__main__':
    n_ = 4
    results_ = generate_matrix(n_)
    for row in results_:
        print(row)

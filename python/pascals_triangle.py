# @author Huaze Shen
# @date 2020-02-02


def generate(num_rows):
    results = []
    for i in range(num_rows):
        if i == 0:
            results.append([1])
        if i == 1:
            results.append([1, 1])
        if i >= 2:
            last_row = results[i - 1]
            row = [1]
            for j in range(0, i - 1):
                row.append(last_row[j] + last_row[j + 1])
            row.append(1)
            results.append(row)
    return results


if __name__ == '__main__':
    results_ = generate(5)
    for row_ in results_:
        print(row_)

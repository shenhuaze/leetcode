# @author Huaze Shen
# @date 2020-02-08


def max_profit(prices):
    if prices is None or len(prices) == 0:
        return 0
    local_values = [0 for i in range(3)]
    globals_values = [0 for i in range(3)]
    for i in range(len(prices) - 1):
        diff = prices[i + 1] - prices[i]
        for j in reversed(range(1, 3)):
            if diff > 0:
                local_values[j] = max(local_values[j] + diff, globals_values[j - 1] + diff)
            else:
                local_values[j] = max(local_values[j] + diff, globals_values[j - 1])
            globals_values[j] = max(local_values[j], globals_values[j])
    return globals_values[2]


if __name__ == '__main__':
    print(max_profit([3, 3, 5, 0, 0, 3, 1, 4]))

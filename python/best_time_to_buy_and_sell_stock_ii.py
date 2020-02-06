# @author Huaze Shen
# @date 2020-02-06


def max_profit(prices):
    result = 0
    for i in range(len(prices) - 1):
        if prices[i] < prices[i + 1]:
            result += prices[i + 1] - prices[i]
    return result


if __name__ == '__main__':
    print(max_profit([7, 1, 5, 3, 6, 4]))

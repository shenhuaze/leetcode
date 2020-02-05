# @author Huaze Shen
# @date 2020-02-05


def max_profit(prices):
    result = 0
    min_price = 2**31 - 1
    for price in prices:
        min_price = min(price, min_price)
        result = max(price - min_price, result)
    return result


if __name__ == '__main__':
    prices_ = [7, 1, 5, 3, 6, 4]
    print(max_profit(prices_))

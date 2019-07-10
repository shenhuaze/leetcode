"""
Author: Huaze Shen
Date: 2019-07-10
"""


def divide(dividend, divisor):
    if dividend == -2**31 and divisor == -1:
        return 2**31 - 1
    dvd = abs(dividend)
    dvs = abs(divisor)
    ans = 0
    is_same_sign = (dividend > 0) == (divisor > 0)
    while dvd >= dvs:
        temp = dvs
        m = 1
        while temp << 1 <= dvd:
            temp <<= 1
            m <<= 1
        dvd -= temp
        ans += m
    if is_same_sign:
        return ans
    else:
        return -ans


if __name__ == '__main__':
    dividend_ = 10
    divisor_ = 3
    print(divide(dividend_, divisor_))

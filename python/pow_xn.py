"""
@author Huaze Shen
@date 2019-07-26
"""


def my_pow(x, n):
    if n == 0:
        return 1
    if n < 0:
        half = 1 / my_pow(x, -n // 2)
    else:
        half = my_pow(x, n // 2)
    if n % 2 == 0:
        return half * half
    if n > 0:
        return half * half * x
    else:
        return half * half / x


if __name__ == '__main__':
    x_ = 34.00515
    n_ = -3
    print(my_pow(x_, n_))

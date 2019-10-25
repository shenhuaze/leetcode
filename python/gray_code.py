"""
@author Huaze Shen
@date 2019-10-23
"""


def gray_code(n):
    result = []
    # for i in range(2**n):
    for i in range(pow(2, n)):
        result.append((i >> 1) ^ i)
    return result


if __name__ == '__main__':
    print(gray_code(2))

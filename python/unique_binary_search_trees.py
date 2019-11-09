"""
@author Huaze Shen
@date 2019-11-05
"""


def num_trees(n):
    dp = [0 for i in range(n + 1)]
    dp[0] = 1
    dp[1] = 1
    for i in range(2, n + 1):
        for j in range(i):
            dp[i] += dp[j] * dp[i - 1 - j]
    return dp[n]


if __name__ == '__main__':
    print(num_trees(3))

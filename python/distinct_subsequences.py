# @author Huaze Shen
# @date 2020-01-30


def num_distinct(s, t):
    m = len(t)
    n = len(s)
    dp = [[0 for i in range(n + 1)] for i in range(m + 1)]
    for i in range(n + 1):
        dp[0][i] = 1
    for i in range(1, m + 1):
        dp[i][0] = 0
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if t[i - 1] == s[j - 1]:
                dp[i][j] += dp[i][j - 1] + dp[i - 1][j - 1]
            else:
                dp[i][j] += dp[i][j - 1]
    return dp[m][n]


if __name__ == '__main__':
    s_ = "rabbbit"
    t_ = "rabbit"
    print(num_distinct(s_, t_))

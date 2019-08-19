

def unique_paths(m, n):
    if m <= 0 or n <= 0:
        return 0
    dp = [1 for i in range(n)]
    for i in range(1, m):
        for j in range(1, n):
            dp[j] += dp[j - 1]
    return dp[n - 1]


if __name__ == '__main__':
    m_ = 3
    n_ = 2
    print(unique_paths(m_, n_))

# @author Huaze Shen
# @date 2019-11-06


def is_interleave(s1, s2, s3):
    if len(s1) + len(s2) != len(s3):
        return False
    n1 = len(s1)
    n2 = len(s2)
    dp = [[False for i in range(n2 + 1)] for j in range(n1 + 1)]
    dp[0][0] = True
    for i in range(1, n1 + 1):
        if dp[i - 1][0] and s1[i - 1] == s3[i - 1]:
            dp[i][0] = True
    for i in range(1, n2 + 1):
        if dp[0][i - 1] and s2[i - 1] == s3[i - 1]:
            dp[0][i] = True
    for i in range(1, n1 + 1):
        for j in range(1, n2 + 1):
            if dp[i - 1][j] and s1[i - 1] == s3[i + j - 1]:
                dp[i][j] = True
            if dp[i][j - 1] and s2[j - 1] == s3[i + j - 1]:
                dp[i][j] = True
    return dp[n1][n2]


if __name__ == '__main__':
    s1_ = "aabcc"
    s2_ = "dbbca"
    s3_ = "aadbbcbcac"
    print(is_interleave(s1_, s2_, s3_))

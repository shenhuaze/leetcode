"""
@author Huaze Shen
@date 2019-10-26
"""


def num_decodings(s):
    if s is None or len(s) == 0 or s[0] == '0':
        return 0
    length = len(s)
    dp = [0 for i in range(length + 1)]
    dp[0] = 1
    for i in range(1, length + 1):
        if s[i - 1] != '0':
            dp[i] = dp[i - 1]
        else:
            dp[i] = 0
        if i == 1:
            continue
        if s[i - 2] == '1':
            dp[i] += dp[i - 2]
        if s[i - 2] == '2' and s[i - 1] <= '6':
            dp[i] += dp[i - 2]
    return dp[length]


if __name__ == '__main__':
    # s_ = "226"
    s_ = "10"
    print(num_decodings(s_))

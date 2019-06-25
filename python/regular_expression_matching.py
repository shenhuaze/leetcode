
def is_match(s, p):
    return is_match_recursion(s, p)
    # return is_match_dp(s, p)


def is_match_recursion(s, p):
    if len(p) == 0:
        return len(s) == 0
    elif len(p) == 1:
        return len(s) == 1 and (s == p or "." == p)
    elif p[1] != "*":
        if len(s) == 0:
            return False
        return (s[0] == p[0] or "." == p[0]) and is_match_recursion(s[1:], p[1:])
    else:
        while len(s) != 0 and (s[0] == p[0] or "." == p[0]):
            if is_match_recursion(s, p[2:]):
                return True
            s = s[1:]
    return is_match_recursion(s, p[2:])


def is_match_dp(s, p):
    if s is None or p is None:
        return False
    m = len(s)
    n = len(p)
    dp = [[False for j in range(n + 1)] for i in range(m + 1)]
    dp[0][0] = True
    for i in range(1, n):
        if p[i] == "*" and dp[0][i - 1]:
            dp[0][i + 1] = True
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if p[j - 1] == "." or p[j - 1] == s[i - 1]:
                dp[i][j] = dp[i - 1][j - 1]
            if p[j - 1] == "*":
                if p[j - 2] != s[i - 1] and p[j - 2] != ".":
                    dp[i][j] = dp[i][j - 2]
                else:
                    dp[i][j] = dp[i][j - 2] or dp[i][j - 1] or dp[i - 1][j]
    return dp[m][n]


if __name__ == "__main__":
    s_ = "aa"
    p_ = "a*"
    print(is_match(s_, p_))

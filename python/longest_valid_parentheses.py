"""
Author: Huaze Shen
Date: 2019-07-12
"""


def longest_valid_parentheses(s):
    """
    Solution 1: brute force
    """
    max_len = 0
    for i in range(len(s)):
        for j in range(i + 2, len(s) + 1):
            if is_valid(s[i:j]):
                max_len = max(max_len, j - i)
    return max_len


def is_valid(s):
    stack = []
    for i in range(len(s)):
        if s[i] == "(":
            stack.append("(")
        elif len(stack) > 0:
            stack.pop()
        else:
            return False
    return len(stack) == 0


def longest_valid_parentheses2(s):
    """
    Solution 2
    """
    max_len = 0
    start = 0
    stack = []
    for i in range(len(s)):
        if s[i] == "(":
            stack.append(i)
        else:
            if len(stack) == 0:
                start = i + 1
            else:
                stack.pop()
                if len(stack) == 0:
                    max_len = max(max_len, i - start + 1)
                else:
                    max_len = max(max_len, i - stack[len(stack) - 1])
    return max_len


def longest_valid_parentheses3(s):
    """
    Solution 3
    """
    max_len = 0
    dp = [0 for i in range(len(s))]
    for i in range(1, len(s)):
        if s[i] == ")":
            if s[i - 1] == "(":
                if i >= 2:
                    dp[i] = dp[i - 2] + 2
                else:
                    dp[i] = 2
            elif i - dp[i - 1] > 0 and s[i - dp[i - 1] - 1] == "(":
                if i - dp[i - 1] >= 2:
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
                else:
                    dp[i] = dp[i - 1] + 2
            max_len = max(max_len, dp[i])
    return max_len


def longest_valid_parentheses4(s):
    max_len = 0
    left = 0
    right = 0
    for i in range(len(s)):
        if s[i] == "(":
            left += 1
        else:
            right += 1
        if left == right:
            max_len = max(max_len, left * 2)
        elif right > left:
            left = 0
            right = 0
    left = 0
    right = 0
    for i in reversed(range(len(s))):
        if s[i] == "(":
            left += 1
        else:
            right += 1
        if left == right:
            max_len = max(max_len, left * 2)
        elif left > right:
            left = 0
            right = 0
    return max_len


if __name__ == '__main__':
    s_ = "(()"
    print(longest_valid_parentheses(s_))
    print(longest_valid_parentheses2(s_))
    print(longest_valid_parentheses3(s_))
    print(longest_valid_parentheses4(s_))

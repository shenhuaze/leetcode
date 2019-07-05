"""
Author: Huaze Shen
Date: 2019-07-04
"""


def generate_parenthesis(n):
    results = []
    dfs(results, 0, 0, "", n)
    return results


def dfs(results, left, right, current, n):
    if left < right:
        return
    if left == n and right == n:
        results.append(current)
    if left < n:
        dfs(results, left + 1, right, current + "(", n)
    if right < n:
        dfs(results, left, right + 1, current + ")", n)


if __name__ == "__main__":
    print(generate_parenthesis(3))

"""
Author: Huaze Shen
Date: 2019-07-10
"""


def str_str(haystack, needle):
    """
    Solution 1
    超时
    """
    if needle is None or len(needle) == 0:
        return 0
    if len(haystack) < len(needle):
        return -1
    for i in range(len(haystack)):
        if needle[0] != haystack[i]:
            continue
        j = 0
        while j < len(needle):
            if i + j >= len(haystack):
                break
            if needle[j] != haystack[i + j]:
                break
            j += 1
        if j == len(needle):
            return i
    return -1


def str_str2(haystack, needle):
    """
    Solution 2
    直接使用find函数，通过OJ
    """
    return haystack.find(needle)


if __name__ == "__main__":
    haystack_ = "hello"
    needle_ = "ll"
    # print(str_str(haystack_, needle_))
    print(str_str2(haystack_, needle_))

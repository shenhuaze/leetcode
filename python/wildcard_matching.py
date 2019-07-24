"""
@author Huaze Shen
@date 2019-07-23
"""


def is_match(s, p):
    i = 0
    j = 0
    i_star = -1
    j_star = -1
    while i < len(s):
        if j < len(p) and (p[j] == s[i] or p[j] == '?'):
            i += 1
            j += 1
        elif j < len(p) and p[j] == "*":
            i_star = i
            j_star = j
            j += 1
        elif i_star >= 0:
            i = i_star + 1
            j = j_star + 1
            i_star += 1
        else:
            return False
    while j < len(p) and p[j] == "*":
        j += 1
    return j == len(p)


if __name__ == '__main__':
    s_ = "abcdefgh"
    p_ = "a*bcdeffh"
    print(is_match(s_, p_))


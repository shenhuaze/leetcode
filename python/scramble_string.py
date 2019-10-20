"""
@author Huaze Shen
@date 2019-10-19
"""


def is_scramble(s1, s2):
    if s1 is None or s2 is None:
        return False
    if len(s1) != len(s2):
        return False
    if s1 == s2:
        return True
    letters = [0 for i in range(26)]
    for i in range(len(s1)):
        letters[ord(s1[i]) - ord('a')] += 1
        letters[ord(s2[i]) - ord('a')] -= 1
    for i in range(26):
        if letters[i] != 0:
            return False
    for i in range(1, len(s1)):
        if is_scramble(s1[0:i], s2[0:i]) and is_scramble(s1[i:], s2[i:]):
            return True
        if is_scramble(s1[0:i], s2[len(s2)-i:]) and is_scramble(s1[i:], s2[0:len(s2)-i]):
            return True
    return False


if __name__ == '__main__':
    s1_ = "great"
    s2_ = "rgeat"
    print(is_scramble(s1_, s2_))

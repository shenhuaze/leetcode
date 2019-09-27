"""
@author Huaze Shen
@date 2019-09-26
"""


def min_window(s, t):
    result = ""
    count = 0
    left = 0
    right = 0
    min_len = len(s) + 1
    letter_count = [0 for i in range(256)]
    for ch in t:
        letter_count[ord(ch)] += 1
    while right < len(s):
        right_ch = s[right]
        letter_count[ord(right_ch)] -= 1
        if letter_count[ord(right_ch)] >= 0:
            count += 1
        while count == len(t):
            if right - left + 1 < min_len:
                min_len = right - left + 1
                result = s[left: right + 1]
            left_ch = s[left]
            letter_count[ord(left_ch)] += 1
            if letter_count[ord(left_ch)] > 0:
                count -= 1
            left += 1
        right += 1
    return result


if __name__ == '__main__':
    s_ = "ADOBECODEBANC"
    t_ = "ABC"
    print(min_window(s_, t_))

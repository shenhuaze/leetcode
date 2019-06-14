
def length_of_longest_substring(s):
    char_positions = {}
    left = -1
    max_len = 0
    for i in range(len(s)):
        ch = s[i]
        if ch in char_positions and char_positions[ch] > left:
            left = char_positions[ch]
        char_positions[ch] = i
        max_len = max(max_len, i - left)
    return max_len


if __name__ == "__main__":
    # s_ = "abcabcbb"
    s_ = "aab"
    max_len_ = length_of_longest_substring(s_)
    print(max_len_)

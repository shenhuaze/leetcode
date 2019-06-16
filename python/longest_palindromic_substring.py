
def longest_palindrome(s):
    """
    Solution 1
    """
    if len(s) < 2:
        return s
    start = 0
    max_len = 0
    for i in range(len(s) - 1):
        start_odd, max_len_odd = search_palindrome(s, i, i)
        start_even, max_len_even = search_palindrome(s, i, i + 1)
        if max_len < max_len_odd:
            start = start_odd
            max_len = max_len_odd
        if max_len < max_len_even:
            start = start_even
            max_len = max_len_even
    return s[start: start + max_len]


def longest_palindrome2(s):
    """
    Solution 2
    """
    if len(s) < 2:
        return s
    start = 0
    max_len = 0
    i = 0
    while i < len(s) - 1:
        if max_len / 2 > len(s) - i:
            break
        left = i
        right = i
        while right < len(s) - 1 and s[right] == s[right + 1]:
            right += 1
        i = right + 1
        start_temp, max_len_temp = search_palindrome(s, left, right)
        if max_len < max_len_temp:
            start = start_temp
            max_len = max_len_temp
    return s[start: start + max_len]


def search_palindrome(s, left, right):
    while left >= 0 and right < len(s) and s[left] == s[right]:
        left -= 1
        right += 1
    return left + 1, right - left - 1


if __name__ == "__main__":
    s = "dcbab"
    # palindrome = longest_palindrome(s)
    palindrome = longest_palindrome2(s)
    print(palindrome)

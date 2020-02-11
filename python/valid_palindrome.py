# @author Huaze Shen
# @date 2020-02-10


def is_palindrome(s):
    if s is None:
        return True
    left = 0
    right = len(s) - 1
    while left < right:
        if not is_alphabet(s[left]):
            left += 1
        elif not is_alphabet(s[right]):
            right -= 1
        elif lower(s[left]) != lower(s[right]):
            return False
        else:
            left += 1
            right -= 1
    return True


def lower(ch):
    if 'A' <= ch <= 'Z':
        return chr(ord(ch) + 32)
    return ch


def is_alphabet(ch):
    if '0' <= ch <= '9':
        return True
    if 'a' <= ch <= 'z':
        return True
    if 'A' <= ch <= 'Z':
        return True
    return False


if __name__ == '__main__':
    print(is_alphabet("A man, a plan, a canal: Panama"))

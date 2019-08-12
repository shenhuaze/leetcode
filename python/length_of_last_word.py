

def length_of_last_word(s):
    if s is None or len(s.strip()) == 0:
        return 0
    if " " not in s:
        return len(s)
    i = len(s) - 1
    while i >= 0 and s[i] == " ":
        i -= 1
    length = 0
    while i >= 0 and s[i] != " ":
        length += 1
        i -= 1
    return length


if __name__ == '__main__':
    # s_ = "Hello World"
    s_ = "a"
    print(length_of_last_word(s_))

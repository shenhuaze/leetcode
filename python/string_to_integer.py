
def my_atoi(str):
    if str is None or len(str.strip()) == 0:
        return 0
    sign = 1
    base = 0
    i = 0
    n = len(str)
    while i < n and str[i] == ' ':
        i += 1
    if i < n and (str[i] == '-' or str[i] == '+'):
        if str[i] == '-':
            sign = -1
        i += 1
    max_int = 2**31 - 1
    min_int = -2**31
    while i < n and '0' <= str[i] <= '9':
        if base > max_int // 10 or (base == max_int // 10 and ord(str[i]) - ord('0') > 7):
            if sign == 1:
                return max_int
            else:
                return min_int
        base = ord(str[i]) - ord('0') + base * 10
        i += 1
    return sign * base


if __name__ == "__main__":
    str_ = "  -42"
    print(my_atoi(str_))


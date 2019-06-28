
def roman_to_int(s):
    dic = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    num = 0
    for i in range(len(s)):
        if i == len(s) - 1:
            num += dic[s[i]]
        elif dic[s[i]] >= dic[s[i + 1]]:
            num += dic[s[i]]
        else:
            num -= dic[s[i]]
    return num


if __name__ == "__main__":
    s_ = "MCMXCIV"
    print(roman_to_int(s_))

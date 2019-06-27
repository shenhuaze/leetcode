
def int_to_roman(num):
    roman = ['M', 'D', 'C', 'L', 'X', 'V', 'I']
    value = [1000, 500, 100, 50, 10, 5, 1]
    result = ""
    i = 0
    while i < len(roman):
        x = num // value[i]
        if x < 4:
            for j in range(1, x + 1):
                result += roman[i]
        elif x == 4:
            result += roman[i]
            result += roman[i - 1]
        elif x < 9:
            result += roman[i - 1]
            for j in range(6, x + 1):
                result += roman[i]
        elif x == 9:
            result += roman[i]
            result += roman[i - 2]
        num %= value[i]
        i += 2
    return result


if __name__ == "__main__":
    num_ = 1994
    print(int_to_roman(num_))

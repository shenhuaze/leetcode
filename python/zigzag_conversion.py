
def convert(s, num_rows):
    if num_rows <= 1:
        return s
    result = ""
    for i in range(num_rows):
        j = i
        while j < len(s):
            result += s[j]
            temp = j + 2 * num_rows - 2 - 2 * i
            if 0 < i < num_rows and temp < len(s):
                result += s[temp]
            j += 2 * num_rows - 2
    return result


if __name__ == "__main__":
    s_ = "PAYPALISHIRING"
    num_rows_ = 3
    result_ = convert(s_, num_rows_)
    print(result_)


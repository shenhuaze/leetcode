
def reverse(x):
    result = 0
    sign = 1
    if x < 0:
        sign = -1
        x = -x
    max_int = 2**31 - 1
    while x != 0:
        if abs(result) > max_int // 10:
            return 0
        result = result * 10 + x % 10
        x = x // 10
    return sign * result


if __name__ == "__main__":
    # x_ = 123
    # x_ = -123
    x_ = 1534236469
    result_ = reverse(x_)
    print(result_)

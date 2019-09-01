

def add_binary(a, b):
    if a is None or len(a) == 0:
        return b
    if b is None or len(b) == 0:
        return a
    i = len(a) - 1
    j = len(b) - 1
    carry = 0
    result = ""
    while i >= 0 or j >= 0:
        sum_ = carry
        if i >= 0:
            sum_ += ord(a[i]) - ord('0')
            i -= 1
        if j >= 0:
            sum_ += ord(b[j]) - ord('0')
            j -= 1
        result = str(sum_ % 2) + result
        carry = sum_ // 2
    if carry > 0:
        result = str(carry) + result
    return result


if __name__ == '__main__':
    a_ = "1010"
    b_ = "1011"
    print(add_binary(a_, b_))

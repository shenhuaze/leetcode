"""
@author Huaze Shen
@date 2019-07-20
"""


def multiply(num1, num2):
    m = len(num1)
    n = len(num2)
    pos = [0 for i in range(m + n)]
    for i in reversed(range(m)):
        for j in reversed(range(n)):
            mul = (ord(num1[i]) - ord('0')) * (ord(num2[j]) - ord('0'))
            p1 = i + j
            p2 = i + j + 1
            sum_ = mul + pos[p2]
            pos[p1] += sum_ // 10
            pos[p2] = sum_ % 10
    result = ""
    for i in pos:
        if len(result) == 0 and i == 0:
            continue
        result += str(i)
    if len(result) == 0:
        return "0"
    return result


if __name__ == '__main__':
    num1_ = "123"
    num2_ = "456"
    print(multiply(num1_, num2_))

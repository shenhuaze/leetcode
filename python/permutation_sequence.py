

def get_permutation(n, k):
    result = ""
    num = "123456789"
    factorial = [1]
    for i in range(1, n):
        factorial.append(factorial[i - 1] * i)
    k -= 1
    for i in range(n):
        index = k // factorial[n - i - 1]
        k %= factorial[n - i - 1]
        result += str(num[index])
        if index == n - 1:
            num = num[:index]
        else:
            num = num[:index] + num[index + 1:]
    return result


if __name__ == '__main__':
    n_ = 4
    k_ = 9
    print(get_permutation(n_, k_))

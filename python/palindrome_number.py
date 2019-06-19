
def is_palindrome(x):
    if x < 0:
        return False
    divided_number = 1
    while x // divided_number >= 10:
        divided_number *= 10
    while x > 0:
        left = x // divided_number
        right = x % 10
        if left != right:
            return False
        x = (x % divided_number) // 10
        divided_number //= 100
    return True


if __name__ == "__main__":
    x_ = 1001
    print(is_palindrome(x_))

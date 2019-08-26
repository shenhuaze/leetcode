

def plus_one(digits):
    if digits is None or len(digits) == 0:
        return []
    size = len(digits)
    for i in reversed(range(size)):
        if digits[i] < 9:
            digits[i] += 1
            return digits
        digits[i] = 0
    new_digits = [0 for i in range(size + 1)]
    new_digits[0] = 1
    return new_digits


if __name__ == '__main__':
    # digits_ = [1, 2, 3]
    digits_ = [9, 9, 9]
    print(plus_one(digits_))

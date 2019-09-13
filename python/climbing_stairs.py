

def climb_stairs(n):
    if n == 1:
        return n
    a = 1
    b = 2
    for i in range(3, n + 1):
        b += a
        a = b - a
    return b


if __name__ == '__main__':
    print(climb_stairs(3))

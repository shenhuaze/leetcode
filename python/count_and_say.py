"""
@author Huaze Shen
@date 2019-07-17
"""


def count_and_say(n):
    if n <= 0:
        return ""
    result = "1"
    for i in range(1, n):
        temp = result
        result = ""
        j = 0
        while j < len(temp):
            count = 0
            ch = temp[j]
            for k in range(j, len(temp)):
                if temp[k] != ch:
                    break
                count += 1
            result += str(count)
            result += ch
            j += count
    return result


if __name__ == '__main__':
    print(count_and_say(4))

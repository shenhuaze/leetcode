"""
@author Huaze Shen
@date 2019-10-27
"""


def restore_ip_addresses(s):
    results = []
    restore(results, s, "", 4)
    return results


def restore(results, remain, result, k):
    if k == 0:
        if len(remain) == 0:
            results.append(result)
    else:
        for i in range(1, 4):
            if len(remain) >= i and is_valid(remain[0:i]):
                if k == 1:
                    restore(results, remain[i:], result + remain[0:i], k - 1)
                else:
                    restore(results, remain[i:], result + remain[0:i] + ".", k - 1)


def is_valid(s):
    if len(s) > 1 and s[0] == '0':
        return False
    return 0 <= int(s) < 256


if __name__ == '__main__':
    s_ = "25525511135"
    print(restore_ip_addresses(s_))

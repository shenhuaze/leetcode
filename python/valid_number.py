import re


def is_number(s):
    if s is None or len(s.strip()) == 0:
        return False
    regex = "[-+]?(?:[0-9]+\.?|\.[0-9]+)[0-9]*(?:e[-+]?[0-9]+)?"
    return re.fullmatch(regex, s.strip()) is not None


if __name__ == '__main__':
    # s_ = "53.5e93"
    s_ = "0e"
    print(is_number(s_))

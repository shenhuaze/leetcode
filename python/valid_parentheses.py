
def is_valid(s):
    stack = []
    for i in range(len(s)):
        if s[i] == "(" or s[i] == "[" or s[i] == "{":
            stack.append(s[i])
        else:
            if len(stack) == 0:
                return False
            if s[i] == ")" and stack[-1] != "(":
                return False
            if s[i] == "]" and stack[-1] != "[":
                return False
            if s[i] == "}" and stack[-1] != "{":
                return False
            stack.pop()
    return len(stack) == 0


if __name__ == "__main__":
    s_ = "()[]{}"
    print(is_valid(s_))

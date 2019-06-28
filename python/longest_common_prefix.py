
def longest_common_prefix(strs):
    if strs is None or len(strs) == 0:
        return ""
    for i in range(len(strs[0])):
        prefix = strs[0][: i + 1]
        for j in range(len(strs)):
            if not strs[j].startswith(prefix):
                return strs[0][:i]
    return strs[0]


if __name__ == "__main__":
    strs_ = ["flower", "flow", "flight"]
    print(longest_common_prefix(strs_))

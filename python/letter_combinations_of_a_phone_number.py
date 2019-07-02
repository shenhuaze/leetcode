
def letter_combinations(digits):
    if digits is None or len(digits) == 0:
        return []
    digit_letter = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
    results = []
    dfs(results, "", 0, digit_letter, digits)
    return results


def dfs(results, prefix, index, digit_letter, digits):
    if index == len(digits):
        results.append(prefix)
        return
    digit = int(digits[index])
    letters = digit_letter[digit]
    for i in range(len(letters)):
        dfs(results, prefix + letters[i], index + 1, digit_letter, digits)


if __name__ == "__main__":
    digits_ = "23"
    print(letter_combinations(digits_))

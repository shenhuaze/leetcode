"""
Author: Huaze Shen
Date: 2019-07-11
"""


def find_substring(s, words):
    result = []
    if s is None or len(s) == 0:
        return result
    if words is None or len(words) == 0:
        return result
    word_count = {}
    for word in words:
        if word not in word_count:
            word_count[word] = 0
        # word_count[word] = word_count[word] + 1
        word_count[word] += 1
    num_words = len(words)
    word_length = len(words[0])
    for i in range(len(s) - num_words * word_length + 1):
        temp_word_count = {}
        j = 0
        while j < num_words:
            temp_word = s[i + j * word_length: i + (j + 1) * word_length]
            if temp_word not in word_count:
                break
            if temp_word not in temp_word_count:
                temp_word_count[temp_word] = 0
            # temp_word_count[temp_word] = temp_word_count[temp_word] + 1
            temp_word_count[temp_word] += 1
            if temp_word_count[temp_word] > word_count[temp_word]:
                break
            j += 1
        if j == num_words:
            result.append(i)
    return result


if __name__ == '__main__':
    # s_ = "barfoothefoobarman"
    s_ = "a"
    word_ = ["a", "a"]
    print(find_substring(s_, word_))

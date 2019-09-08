

def full_justify(words, max_width):
    results = []
    if words is None or len(words) == 0:
        return results
    i = 0
    while i < len(words):
        j = i
        words_sum_length = 0
        while j < len(words) and words_sum_length + len(words[j]) + j - i <= max_width:
            words_sum_length += len(words[j])
            j += 1
        remaining_space = max_width - words_sum_length
        line = ""
        for k in range(i, j):
            line += words[k]
            if remaining_space > 0:
                if j == len(words):
                    if j - k > 1:
                        current_space = 1
                    else:
                        current_space = remaining_space
                else:
                    if j - k > 1:
                        if remaining_space % (j - k - 1) == 0:
                            current_space = remaining_space // (j - k - 1)
                        else:
                            current_space = remaining_space // (j - k - 1) + 1
                    else:
                        current_space = remaining_space
                line += " " * current_space
                remaining_space -= current_space
        results.append(line)
        i = j
    return results


if __name__ == '__main__':
    # words_ = ["This", "is", "an", "example", "of", "text", "justification."]
    words_ = ["What", "must", "be", "acknowledgment", "shall", "be"]
    # words_ = ["Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
    #           "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"]
    max_width_ = 16
    # max_width_ = 20
    results_ = full_justify(words_, max_width_)
    for line_ in results_:
        print("\"" + line_ + "\"")

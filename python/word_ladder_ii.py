# @author Huaze Shen
# @date 2020-03-03


def find_ladders(begin_word, end_word, word_list):
    """
    找出从begin_word到end_word的路径
    Args:
        begin_word: 起始词
        end_word: 结束词
        word_list: 候选词列表
    Returns:
        paths: 从begin_word到end_word的路径
    """
    if end_word not in word_list:
        return []
    word_set = set(word_list)
    paths = []
    path = []
    neighbors = {}
    distances = {}
    word_set.add(begin_word)
    bfs(end_word, word_set, neighbors, distances)
    dfs(paths, path, begin_word, end_word, neighbors, distances)
    return paths


def bfs(end_word, word_set, neighbors, distances):
    """
    从end_word开始做bfs，找出每个词的邻居词，以及每个词与end_word之间的距离
    Args:
        end_word: 结束词
        word_set: set，候选词典
        neighbors: dict，存储每个词的邻居词
        distances: dict，存储每个词到end_word的距离
    """
    queue = [end_word]
    distances[end_word] = 0
    for word in word_set:
        neighbors[word] = []
    while len(queue) > 0:
        word = queue.pop(0)
        for next_word in get_next_words(word_set, word):
            neighbors[word].append(next_word)
            if next_word not in distances:
                distances[next_word] = distances[word] + 1
                queue.append(next_word)


def get_next_words(word_set, word):
    """
    从word_set中找出word的所有邻居词
    Args:
        word_set: 候选词典
        word: 目标词
    """
    next_words = []
    for i in range(len(word)):
        ch = word[i]
        for j in range(26):
            c = chr(ord('a') + j)
            if c == ch:
                continue
            next_word = word[0:i] + c + word[i+1:]
            if next_word in word_set:
                next_words.append(next_word)
    return next_words


def dfs(paths, path, current_word, end_word, neighbors, distances):
    """
    从begin_word开始做dfs，找到所有从begin_word到end_word的最短路径
    Args:
        paths: 所有从begin_word到end_word的最短路径
        path: 每一条从begin_word到end_word的最短路径
        current_word: 当前词，最初为begin_word
        end_word: 结束词
        neighbors: 每个词的邻居词
        distances: 每个词到end_word的距离
    """
    path.append(current_word)
    if current_word == end_word:
        paths.append(path[:])
    else:
        for next_word in neighbors[current_word]:
            if next_word in distances and distances[next_word] + 1 == distances[current_word]:
                dfs(paths, path, next_word, end_word, neighbors, distances)
    path.pop(len(path) - 1)


if __name__ == '__main__':
    word_list_ = ["hot", "dot", "dog", "lot", "log", "cog"]
    # word_list_ = ["hot", "dot", "dog", "lot", "log"]
    print(find_ladders("hit", "cog", word_list_))


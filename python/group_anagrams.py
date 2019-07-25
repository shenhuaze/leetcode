"""
@author Huaze Shen
@date 2019-07-25
"""


def group_anagrams(strs):
    results = []
    if strs is None or len(strs) == 0:
        return results
    dic = {}
    for s in strs:
        sorted_s = "".join(sorted(s))
        if sorted_s not in dic:
            dic[sorted_s] = []
        dic[sorted_s].append(s)
    for s in dic:
        results.append(dic[s])
    return results


if __name__ == '__main__':
    strs_ = ["eat", "tea", "tan", "ate", "nat", "bat"]
    print(group_anagrams(strs_))

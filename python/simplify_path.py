

def simplify_path(path):
    result = []
    split = path.split("/")
    for s in split:
        if len(s) == 0 or s == ".":
            continue
        if s == "..":
            if len(result) > 0:
                result.pop()
        else:
            result.append(s)
    return "/" + "/".join(result)


if __name__ == '__main__':
    path_ = "/a/../../b/../c//.//"
    print(simplify_path(path_))

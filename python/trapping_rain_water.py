"""
@author Huaze Shen
@date 2019-07-19
"""


def trap(height):
    """
    Solution 1: Brute force
    """
    if height is None or len(height) == 0:
        return 0
    result = 0
    for i in range(len(height)):
        max_left = 0
        max_right = 0
        for j in range(i + 1):
            max_left = max(height[j], max_left)
        for j in range(i, len(height)):
            max_right = max(height[j], max_right)
        result += min(max_left, max_right) - height[i]
    return result


def trap2(height):
    """
    Solution 2: Dynamic programming
    """
    if height is None or len(height) == 0:
        return 0
    result = 0
    size = len(height)
    max_left = [0 for i in range(size)]
    max_left[0] = height[0]
    for i in range(1, size):
        max_left[i] = max(max_left[i - 1], height[i])
    max_right = [0 for i in range(size)]
    max_right[size - 1] = height[size - 1]
    for i in reversed(range(size - 1)):
        max_right[i] = max(max_right[i + 1], height[i])
    for i in range(size):
        result += min(max_left[i], max_right[i]) - height[i]
    return result


if __name__ == '__main__':
    height_ = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    # print(trap(height_))
    print(trap2(height_))

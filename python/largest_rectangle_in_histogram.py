"""
@author Huaze Shen
@date 2019-10-06
"""


def largest_rectangle_area(heights):
    result = 0
    for i in range(len(heights)):
        if i < len(heights) - 1 and heights[i] <= heights[i + 1]:
            continue
        min_h = heights[i]
        for j in reversed(range(i + 1)):
            min_h = min(min_h, heights[j])
            area = min_h * (i - j + 1)
            result = max(area, result)
    return result


if __name__ == '__main__':
    heights_ = [2, 1, 5, 6, 2, 3]
    print(largest_rectangle_area(heights_))
